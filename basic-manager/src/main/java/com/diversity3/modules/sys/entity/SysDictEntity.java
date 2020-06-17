package com.diversity3.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.diversity3.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_dict")
public class SysDictEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 字典名称
     */
	private String name;
    /**
     * 字典类型
     */
	private String type;
    /**
     * 字典值
     */
	private String value;
    /**
     * 状态  0：停用   1：正常
     */
	private Integer status;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新者
     */
	private Long updater;
    /**
     * 更新时间
     */
	private Date updateTime;
}