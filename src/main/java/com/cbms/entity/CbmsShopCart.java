package com.cbms.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import reactor.core.Fuseable;
import springfox.documentation.spring.web.json.Json;

import java.math.BigDecimal;

// 购物车
@Data
public class CbmsShopCart {

    // 项目id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    // 项目名称
    private String name;

    // 项目价格
    private BigDecimal price;

    // 项目数量
    private Integer num;
}
