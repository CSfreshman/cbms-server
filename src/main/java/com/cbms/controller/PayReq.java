package com.cbms.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class PayReq {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;
}
