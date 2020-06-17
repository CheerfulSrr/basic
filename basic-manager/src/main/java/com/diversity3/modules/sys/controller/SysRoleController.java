package com.diversity3.modules.sys.controller;

import com.diversity3.common.Result;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.common.utils.ExcelUtils;
import com.diversity3.modules.sys.dto.SysRoleDto;
import com.diversity3.modules.sys.entity.SysRoleEntity;
import com.diversity3.modules.sys.excel.SysRoleExcel;
import com.diversity3.modules.sys.service.SysRoleService;
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
@RestController
@RequestMapping("/api/sys/sysrole")
@Api(value = "角色", tags = "角色")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.PAGE_NO, value = "分页参数", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = Constants.PAGE_SIZE, value = "查询条件2", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER_BY_FIELD, value = "查询条件3", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER, value = "查询条件4", paramType = "query"),
    })
    //// @RequiresPermissions("sys:sysrole:page")
    public Result<PageUtil<SysRoleDto>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageUtil<SysRoleDto> page = sysRoleService.page(params);
        return Result.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("信息")
    //// @RequiresPermissions("sys:sysrole:info")
    public Result<SysRoleDto> get(@PathVariable("id") Long id) {
        SysRoleEntity data = sysRoleService.getById(id);
        SysRoleDto dto = ConvertUtils.sourceToTarget(data, SysRoleDto.class);
        return Result.ok(dto);
    }

    @PostMapping
    @ApiOperation("保存")
    // @LogOperation("保存")
    //// @RequiresPermissions("sys:sysrole:save")
    public Result save(@RequestBody SysRoleDto dto) {
        //效验数据
        SysRoleEntity data = ConvertUtils.sourceToTarget(dto, SysRoleEntity.class);
        sysRoleService.save(data);
        return Result.ok();
    }

    @PutMapping
    @ApiOperation("修改")
    // @LogOperation("修改")
    //// @RequiresPermissions("sys:sysrole:update")
    public Result update(@RequestBody SysRoleDto dto) {
        //效验数据
        SysRoleEntity data = ConvertUtils.sourceToTarget(dto, SysRoleEntity.class);
        sysRoleService.update(data);
        return Result.ok();
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改")
    // @LogOperation("保存或修改")
    //// @RequiresPermissions("sys:sysrole:saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SysRoleDto dto) {
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
    //// @RequiresPermissions("sys:sysrole:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        sysRoleService.removeByIds(Collections.singletonList(ids));
        return Result.ok();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    // @LogOperation("导出")
    // @RequiresPermissions("sys:sysrole:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SysRoleEntity> list = sysRoleService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, SysRoleExcel.class);
    }

}
