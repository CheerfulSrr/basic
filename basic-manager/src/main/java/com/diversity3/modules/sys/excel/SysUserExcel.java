package com.diversity3.modules.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

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
public class SysUserExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "账户名")
    private String userName;
    @Excel(name = "真实姓名")
    private String realName;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "头像")
    private String headUrl;
    @Excel(name = "1：男0：女")
    private Integer gender;
    @Excel(name = "手机号")
    private String phone;
    @Excel(name = "邮箱")
    private String mail;
    @Excel(name = "状态  0：停用   1：正常")
    private Integer status;
    @Excel(name = "部门id")
    private Long deptId;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "更新者")
    private Long updater;
    @Excel(name = "更新时间")
    private Date updateTime;

}