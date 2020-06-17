package com.diversity3.modules.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

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
public class SysDictExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "字典名称")
    private String name;
    @Excel(name = "字典类型")
    private String type;
    @Excel(name = "字典值")
    private String value;
    @Excel(name = "状态  0：停用   1：正常")
    private Integer status;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "更新者")
    private Long updater;
    @Excel(name = "更新时间")
    private Date updateTime;

}