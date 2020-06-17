package com.diversity3.modules.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

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
@Data
public class SysRoleExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "角色名")
    private String name;
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