package com.diversity3.modules.sys.controller;

import com.diversity3.common.Result;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.common.utils.ExcelUtils;
import com.diversity3.modules.sys.dto.SysPermissionDto;
import com.diversity3.modules.sys.entity.SysPermissionEntity;
import com.diversity3.modules.sys.excel.SysPermissionExcel;
import com.diversity3.modules.sys.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


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
@RestController
@RequestMapping("/api/sys/syspermission")
@Api(value = "权限", tags = "权限")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.PAGE_NO, value = "分页参数", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = Constants.PAGE_SIZE, value = "查询条件2", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER_BY_FIELD, value = "查询条件3", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER, value = "查询条件4", paramType = "query"),
    })
    //// @RequiresPermissions("sys:syspermission:page")
    public Result<PageUtil<SysPermissionDto>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageUtil<SysPermissionDto> page = sysPermissionService.page(params);
        return Result.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("信息")
    //// @RequiresPermissions("sys:syspermission:info")
    public Result<SysPermissionDto> get(@PathVariable("id") Long id) {
        SysPermissionEntity data = sysPermissionService.getById(id);
        SysPermissionDto dto = ConvertUtils.sourceToTarget(data, SysPermissionDto.class);
        return Result.ok(dto);
    }

    @PostMapping
    @ApiOperation("保存")
    // @LogOperation("保存")
    //// @RequiresPermissions("sys:syspermission:save")
    public Result save(@RequestBody SysPermissionDto dto) {
        //效验数据
        SysPermissionEntity data = ConvertUtils.sourceToTarget(dto, SysPermissionEntity.class);
        sysPermissionService.save(data);
        return Result.ok();
    }

    @PutMapping
    @ApiOperation("修改")
    // @LogOperation("修改")
    //// @RequiresPermissions("sys:syspermission:update")
    public Result update(@RequestBody SysPermissionDto dto) {
        //效验数据
        SysPermissionEntity data = ConvertUtils.sourceToTarget(dto, SysPermissionEntity.class);
        sysPermissionService.update(data);
        return Result.ok();
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改")
    // @LogOperation("保存或修改")
    //// @RequiresPermissions("sys:syspermission:saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SysPermissionDto dto) {
        if (dto.getId() == null) {
            save(dto);
        } else {
            update(dto);
        }
        return Result.ok();
    }

    @DeleteMapping
    @ApiOperation("删除")
    // @LogOperation("删除")
    //// @RequiresPermissions("sys:syspermission:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        sysPermissionService.removeByIds(Collections.singletonList(ids));
        return Result.ok();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    // @LogOperation("导出")
    // @RequiresPermissions("sys:syspermission:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SysPermissionEntity> list = sysPermissionService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, SysPermissionExcel.class);
    }

}
