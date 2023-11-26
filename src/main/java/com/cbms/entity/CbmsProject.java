package com.cbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 美容项目表
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("cbms_project")
@ApiModel(value = "CbmsProject对象", description = "美容项目表")
public class CbmsProject extends Model<CbmsProject> {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("项目名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("项目价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("项目介绍")
    @TableField("desc")
    private String desc;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PRICE = "price";

    public static final String DESC = "desc";

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
