package com.diversity3.modules.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

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
public class SysPermissionExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "权限名")
    private String name;
    @Excel(name = "类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址")
    private String url;
    @Excel(name = "权限类型，页面:1，按钮:2")
    private Integer type;
    @Excel(name = "权限表达式")
    private String permissions;
    @Excel(name = "后端接口访问方式")
    private String method;
    @Excel(name = "排序")
    private Integer sort;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "更新者")
    private Long updater;
    @Excel(name = "更新时间")
    private Date updateTime;

}