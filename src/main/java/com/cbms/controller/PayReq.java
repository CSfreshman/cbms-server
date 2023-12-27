package com.cbms.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class PayReq {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    // 商户订单号
    // outTradeNo 和 tradeNo 不能同时为空
    private String outTradeNo;

    // 支付宝支付订单号
    // outTradeNo 和 tradeNo 不能同时为空
    private String tradeNo;

    // 选填
    private String[] queryOptions;
}
