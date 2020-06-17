package com.diversity3.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 字典表
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:45
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 字典表
 * @copyright: Copyright (c) 2020-05-29
 */
@Data
@ApiModel(value = "字典表dto")
public class SysDictDto implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "字典名称")
	private String name;

	@ApiModelProperty(value = "字典类型")
	private String type;

	@ApiModelProperty(value = "字典值")
	private String value;

	@ApiModelProperty(value = "状态  0：停用   1：正常")
	private Integer status;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新者")
	private Long updater;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;


}