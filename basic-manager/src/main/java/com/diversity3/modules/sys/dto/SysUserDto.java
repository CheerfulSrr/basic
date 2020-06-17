package com.diversity3.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 用户
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 用户
 * @copyright: Copyright (c) 2020-05-29
 */
@Data
@ApiModel(value = "用户dto")
public class SysUserDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "账户名")
	private String userName;

	@ApiModelProperty(value = "真实姓名")
	private String realName;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "头像")
	private String headUrl;

	@ApiModelProperty(value = "1：男0：女")
	private Integer gender;

	@ApiModelProperty(value = "手机号")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String mail;

	@ApiModelProperty(value = "状态  0：停用   1：正常")
	private Integer status;

	@ApiModelProperty(value = "部门id")
	private Long deptId;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新者")
	private Long updater;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;


}