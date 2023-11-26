package com.cbms.controller;

import com.cbms.entity.CbmsShopCart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ShopReq {

    // 项目描述
    private String desc;

    // 项目id
    private Long id;

    // 项目名称
    private String name;

    // 项目价格
    private BigDecimal price;

    // 车牌
    private String carCard;

    // 手机号
    private String phone;

    // 购物车数据
    private ShopData cartData;

    // 数量增量
    private Integer plusNum;
}
