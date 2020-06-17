package com.diversity3.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 权限
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 权限
 * @copyright: Copyright (c) 2020-05-29
 */
@Data
@ApiModel(value = "权限dto")
public class SysPermissionDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "权限名")
	private String name;

	@ApiModelProperty(value = "类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址")
	private String url;

	@ApiModelProperty(value = "权限类型，页面:1，按钮:2")
	private Integer type;

	@ApiModelProperty(value = "权限表达式")
	private String permissions;

	@ApiModelProperty(value = "后端接口访问方式")
	private String method;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新者")
	private Long updater;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;


}