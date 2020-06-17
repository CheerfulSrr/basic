package com.diversity3.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.diversity3.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 角色
 * @copyright: Copyright (c) 2020-05-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
	private String name;
    /**
     * 状态  0：停用   1：正常
     */
	private Integer status;
    /**
     * 部门id
     */
	private Long deptId;
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