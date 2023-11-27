package com.cbms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cbms.controller.PayReq;
import com.cbms.controller.ShopData;
import com.cbms.controller.ShopReq;
import com.cbms.core.AjaxResult;
import com.cbms.entity.*;
import com.cbms.mapper.CbmsOrderDetailMapper;
import com.cbms.mapper.CbmsOrderMapper;
import com.cbms.mapper.CbmsUserMapper;
import com.cbms.service.CbmsShopService;
import com.cbms.util.PayUtil;
import com.cbms.util.utils.DateUtils;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CbmsShopServiceImpl implements CbmsShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CbmsUserMapper userMapper;

    @Autowired
    private CbmsOrderMapper orderMapper;

    @Autowired
    private CbmsOrderDetailMapper orderDetailMapper;


    private static String ShopCartKey = "shopCart";

    private static Integer count = 0;

    @Override
    public void addToCart(ShopReq req) {
        Object o = stringRedisTemplate.opsForHash().get(ShopCartKey, req.getId().toString());
        CbmsShopCart cart;
        if(ObjectUtil.isEmpty(o)){
            cart = new CbmsShopCart();
            cart.setId(req.getId());
            cart.setName(req.getName());
            cart.setPrice(req.getPrice());
            cart.setNum(0);
        }else{
            cart = JSONUtil.toBean(o.toString(),CbmsShopCart.class);
        }
        cart.setNum(cart.getNum() + 1);
        stringRedisTemplate.opsForHash().put(ShopCartKey, req.getId().toString(), JSONUtil.toJsonStr(cart));
    }

    @Override
    public ShopData getAll() {
        // 购物车中的全部项目
        List<Object> shopCart = stringRedisTemplate.opsForHash().values(ShopCartKey);
        ShopData res = new ShopData();

        if(ObjectUtil.isEmpty(shopCart)){
            return res;
        }
        System.out.println(shopCart);
        List<CbmsShopCart> cartList = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        Integer totalNum = 0;

        for (Object o : shopCart) {
            //CbmsShopCart one = new CbmsShopCart();
            CbmsShopCart one = JSONUtil.toBean(o.toString(), CbmsShopCart.class);
            cartList.add(one);
            // 总价格+数量*单价
            totalPrice = totalPrice.add(one.getPrice().multiply(BigDecimal.valueOf(one.getNum())));
            totalNum+=one.getNum();
        }

        res.setProjects(cartList);
        res.setTotalNum(totalNum);
        res.setTotalPrice(totalPrice);
        return res;
    }

    @Override
    public AjaxResult updateNum(ShopReq req) {
        System.out.println(req);
        Object o = stringRedisTemplate.opsForHash().get(ShopCartKey, req.getId().toString());
        if(ObjectUtil.isEmpty(o)){
            return AjaxResult.error("购物车中没有该商品");
        }

        CbmsShopCart cart = JSONUtil.toBean(o.toString(),CbmsShopCart.class);

        if(cart.getNum() <= 0){
            return AjaxResult.error("不能继续减少了");
        }

        // plusNum为数量增量，正数为增加，负数为减少
        cart.setNum(cart.getNum() + req.getPlusNum());

        stringRedisTemplate.opsForHash().put(ShopCartKey, req.getId().toString(), JSONUtil.toJsonStr(cart));

        return AjaxResult.success();
    }


    @Transactional
    @Override
    public AjaxResult doOrder(ShopReq req) {
        // 1.生成订单数据
        CbmsOrder order = new CbmsOrder();
        order.setId(IdUtil.getSnowflakeNextId());
        order.setCode(getCode());
        order.setCreateTime(DateUtils.getNowDate());
        order.setUpdateTime(DateUtils.getNowDate());
        // 待支付
        order.setPayState(1);
        order.setCarCode(req.getCarCard());
        order.setPhone(req.getPhone());
        CbmsUser cbmsUser = userMapper.selectOne(new LambdaQueryWrapper<CbmsUser>().eq(CbmsUser::getPhone, req.getPhone()));
        if(ObjectUtil.isEmpty(cbmsUser)){
            return AjaxResult.error("用户不存在，请先联系工作人员注册");
        }
        order.setUserId(cbmsUser.getId());
        order.setTotalPrice(req.getCartData().getTotalPrice());
        order.setRealPrice(req.getCartData().getTotalPrice());
        // 订单主表插入数据库
        int i = orderMapper.insertCbmsOrder(order);
        if(i == 0){
            return AjaxResult.error("订单生成失败");
        }
        // 生成子单数据
        ShopData cartData = req.getCartData();
        List<CbmsOrderDetail> details = new ArrayList<>();
        for (CbmsShopCart project : cartData.getProjects()) {
            CbmsOrderDetail detail = new CbmsOrderDetail();
            detail.setId(IdUtil.getSnowflakeNextId());
            detail.setOrderId(order.getId());
            detail.setOrderCode(order.getCode());
            detail.setProjectId(project.getId());
            // 单价
            detail.setPrice(project.getPrice());
            // 数量
            detail.setCount(project.getNum());
            // 总价
            detail.setRealPrice(project.getPrice().multiply(BigDecimal.valueOf(project.getNum())));
            detail.setCreateTime(DateUtils.getNowDate());
            details.add(detail);

            int i1 = orderDetailMapper.insertCbmsOrderDetail(detail);
            if(i1 == 0){
                return AjaxResult.error("子单插入失败");
            }
        }
        // 应该批量插入



        // 2.删除购物车数据
        stringRedisTemplate.delete(ShopCartKey);
        return AjaxResult.success(order);
    }

    // 支付宝支付
    @Override
    public AjaxResult pay(String orderCode) {
        CbmsOrder order = orderMapper.selectOne(new LambdaQueryWrapper<CbmsOrder>().eq(CbmsOrder::getCode,orderCode));
        if(ObjectUtil.isEmpty(order)){
            return AjaxResult.error("查无订单");
        }
        if(order.getPayState() != 1){
            return AjaxResult.error("订单不处于待支付状态");
        }

        String alipayResp = PayUtil.alipay(order.getCode(), order.getRealPrice().toString(), order.getCarCode(), order.getCarCode());

        System.out.println(alipayResp);
        return AjaxResult.success(alipayResp);

    }

    private String getCode(){
        String s = DateUtils.parseDateToStr(DateUtils.YYYYMMDDHHMMSS, DateUtils.getNowDate());
        return s + count;
    }

}
