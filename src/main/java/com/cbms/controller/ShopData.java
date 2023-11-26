package com.cbms.controller;

import com.cbms.entity.CbmsShopCart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ShopData {
    private Integer totalNum;

    private BigDecimal totalPrice;

    private List<CbmsShopCart> projects;
}
