package com.cbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("cbms_order_detail")
@ApiModel(value = "CbmsOrderDetail对象", description = "订单明细表")
public class CbmsOrderDetail extends Model<CbmsOrderDetail> {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(" 主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("主表订单id")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty("主表订单号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty("项目表")
    @TableField("project_id")
    private Long projectId;

    @TableField(exist = false)
    private String projectName;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("实际价格")
    @TableField("real_price")
    private BigDecimal realPrice;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @TableField("count")
    private Integer count;

    public static final String ID = "id";

    public static final String ORDER_ID = "order_id";

    public static final String ORDER_CODE = "order_code";

    public static final String PROJECT_ID = "project_id";

    public static final String PRICE = "price";

    public static final String REAL_PRICE = "real_price";

    public static final String CREATE_TIME = "create_time";

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
