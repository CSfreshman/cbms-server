package com.cbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wuziwen
 * @since 2023-11-25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("cbms_user")
@ApiModel(value = "CbmsUser对象", description = "用户表")
public class CbmsUser extends Model<CbmsUser> {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("电话")
    @TableField("phone")
    private String phone;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
