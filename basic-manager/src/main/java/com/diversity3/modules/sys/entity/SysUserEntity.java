package com.diversity3.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.diversity3.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 账户名
     */
	private String userName;
    /**
     * 真实姓名
     */
	private String realName;
    /**
     * 密码
     */
	private String password;
    /**
     * 头像
     */
	private String headUrl;
    /**
     * 1：男0：女
     */
	private Integer gender;
    /**
     * 手机号
     */
	private String phone;
    /**
     * 邮箱
     */
	private String mail;
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