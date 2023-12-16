package com.cbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("cbms_order")
@ApiModel(value = "CbmsOrder对象", description = "订单主表")
public class CbmsOrder extends Model<CbmsOrder> {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("订单号")
    @TableField("code")
    private String code;

    @ApiModelProperty("支付类型")
    @TableField("pay_type")
    private Integer payType;

    @ApiModelProperty("支付订单号")
    @TableField("pay_code")
    private String payCode;

    @ApiModelProperty("订单状态（1.待支付，2.支付中，3.支付完成，4.已取消，5.已完成）")
    @TableField("pay_state")
    private Integer payState;

    @ApiModelProperty("联系电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("车牌号")
    @TableField("car_code")
    private String carCode;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("订单总价格")
    @TableField("total_price")
    private BigDecimal totalPrice;

    @ApiModelProperty("订单实际价格")
    @TableField("real_price")
    private BigDecimal realPrice;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String createTimeStr;

    @TableField(exist = false)
    private String updateTimeStr;

    @TableField(exist = false)
    private List<CbmsOrderDetail> orderDetails;

    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String PAY_TYPE = "pay_type";

    public static final String PAY_CODE = "pay_code";

    public static final String PAY_STATE = "pay_state";

    public static final String PHONE = "phone";

    public static final String CAR_CODE = "car_code";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String TOTAL_PRICE = "total_price";

    public static final String REAL_PRICE = "real_price";

    public static final String USER_ID = "user_id";

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
