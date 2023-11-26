package com.cbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cbms.controller.ShopData;
import com.cbms.controller.ShopReq;
import com.cbms.core.AjaxResult;
import com.cbms.entity.CbmsShopCart;

public interface CbmsShopService {

    void addToCart(ShopReq req);

    ShopData getAll();

    AjaxResult updateNum(ShopReq req);

    AjaxResult doOrder(ShopReq req);
}
