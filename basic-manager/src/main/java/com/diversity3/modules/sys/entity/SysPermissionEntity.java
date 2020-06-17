package com.diversity3.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.diversity3.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_permission")
public class SysPermissionEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 权限名
     */
	private String name;
    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
	private String url;
    /**
     * 权限类型，页面:1，按钮:2
     */
	private Integer type;
    /**
     * 权限表达式
     */
	private String permissions;
    /**
     * 后端接口访问方式
     */
	private String method;
    /**
     * 排序
     */
	private Integer sort;
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