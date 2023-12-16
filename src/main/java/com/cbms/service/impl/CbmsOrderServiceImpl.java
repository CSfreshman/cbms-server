package com.cbms.service.impl;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cbms.entity.CbmsOrder;
import com.cbms.entity.CbmsOrderDetail;
import com.cbms.entity.CbmsUser;
import com.cbms.mapper.CbmsOrderDetailMapper;
import com.cbms.mapper.CbmsOrderMapper;
import com.cbms.mapper.CbmsUserMapper;
import com.cbms.service.ICbmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbms.util.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;

/**
 * <p>
 * 订单主表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Service
public class CbmsOrderServiceImpl extends ServiceImpl<CbmsOrderMapper, CbmsOrder> implements ICbmsOrderService {
    @Autowired
    private CbmsOrderMapper cbmsOrderMapper;

    @Autowired
    private CbmsOrderDetailMapper cbmsOrderDetailMapper;

    @Autowired
    private CbmsUserServiceImpl cbmsUserService;

    /**
     * 查询订单主
     *
     * @param id 订单主主键
     * @return 订单主
     */
    @Override
    public CbmsOrder selectCbmsOrderById(Long id)
    {
        CbmsOrder cbmsOrder = cbmsOrderMapper.selectCbmsOrderById(id);
        List<CbmsOrderDetail> orderDetails = cbmsOrderDetailMapper.selectCbmsOrderDetailList(new CbmsOrderDetail().setOrderId(cbmsOrder.getId()));
        cbmsOrder.setOrderDetails(orderDetails);
        cbmsOrder.setCreateTimeStr(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,cbmsOrder.getCreateTime()));
        cbmsOrder.setUpdateTimeStr(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,cbmsOrder.getUpdateTime()));

        cbmsOrder.setUserName("顾客:" + cbmsOrder.getPhone().substring(cbmsOrder.getPhone().length()-4));

        CbmsUser byId = cbmsUserService.getById(cbmsOrder.getUserId());
        if(ObjectUtil.isNotEmpty(byId)){
            cbmsOrder.setUserName(byId.getName());
        }

        return cbmsOrder;
    }

    /**
     * 查询订单主列表
     *
     * @param cbmsOrder 订单主
     * @return 订单主
     */
    @Override
    public List<CbmsOrder> selectCbmsOrderList(CbmsOrder cbmsOrder)
    {
        List<CbmsOrder> cbmsOrders = cbmsOrderMapper.selectCbmsOrderList(cbmsOrder);
        for (CbmsOrder order : cbmsOrders) {
            List<CbmsOrderDetail> orderDetails = cbmsOrderDetailMapper.selectCbmsOrderDetailList(new CbmsOrderDetail().setOrderId(order.getId()));
            order.setOrderDetails(orderDetails);
            order.setCreateTimeStr(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,order.getCreateTime()));
            order.setUpdateTimeStr(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,order.getUpdateTime()));

            order.setUserName("顾客:" + order.getPhone().substring(order.getPhone().length()-4));

            CbmsUser byId = cbmsUserService.getById(order.getUserId());
            if(ObjectUtil.isNotEmpty(byId)){
                order.setUserName(byId.getName());
            }
        }
        return cbmsOrders;
    }

    /**
     * 新增订单主
     *
     * @param cbmsOrder 订单主
     * @return 结果
     */
    @Override
    public int insertCbmsOrder(CbmsOrder cbmsOrder)
    {
        cbmsOrder.setCreateTime(DateUtils.getNowDate());
        return cbmsOrderMapper.insertCbmsOrder(cbmsOrder);
    }

    /**
     * 修改订单主
     *
     * @param cbmsOrder 订单主
     * @return 结果
     */
    @Override
    public int updateCbmsOrder(CbmsOrder cbmsOrder)
    {
        cbmsOrder.setUpdateTime(DateUtils.getNowDate());
        return cbmsOrderMapper.updateCbmsOrder(cbmsOrder);
    }

    /**
     * 批量删除订单主
     *
     * @param ids 需要删除的订单主主键
     * @return 结果
     */
    @Override
    public int deleteCbmsOrderByIds(Long[] ids)
    {
        return cbmsOrderMapper.deleteCbmsOrderByIds(ids);
    }

    /**
     * 删除订单主信息
     *
     * @param id 订单主主键
     * @return 结果
     */
    @Override
    public int deleteCbmsOrderById(Long id)
    {
        return cbmsOrderMapper.deleteCbmsOrderById(id);
    }
}

