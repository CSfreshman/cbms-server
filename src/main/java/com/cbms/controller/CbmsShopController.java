package com.cbms.controller;

import com.cbms.core.AjaxResult;
import com.cbms.service.CbmsShopService;
import com.cbms.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class CbmsShopController {

    @Autowired
    private CbmsShopService service;

    // 获得购物车全部数据
    @PostMapping("/getAll")
    public AjaxResult getAll(){
        ShopData res = service.getAll();
        return AjaxResult.success(res);
    }

    // 下单并支付
    @PostMapping("/doOrder")
    public AjaxResult doOrder(@RequestBody ShopReq req){
        System.out.println(req);

        return service.doOrder(req);
    }

    // 添加商品到购物车
    @PostMapping("/addToCart")
    public AjaxResult addToCart(@RequestBody ShopReq req){
        System.out.println(req);
        service.addToCart(req);
        return AjaxResult.success();
    }

    // 购物车商品数量变化
    @PostMapping("/updateNum")
    public AjaxResult updateNum(@RequestBody ShopReq req){
        return service.updateNum(req);
    }
}
