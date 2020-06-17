package com.diversity3.modules.sys.controller;

import com.diversity3.common.Result;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.common.utils.ExcelUtils;
import com.diversity3.modules.sys.dto.SysDeptDto;
import com.diversity3.modules.sys.entity.SysDeptEntity;
import com.diversity3.modules.sys.excel.SysDeptExcel;
import com.diversity3.modules.sys.service.SysDeptService;
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
 * 部门
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package:  com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 部门
 * @copyright: Copyright (c) 2020-05-29
 */
@RestController
@RequestMapping("/api/sys/sysdept")
@Api(value = "部门", tags = "部门")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.PAGE_NO, value = "分页参数", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = Constants.PAGE_SIZE, value = "查询条件2", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER_BY_FIELD, value = "查询条件3", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER, value = "查询条件4", paramType = "query"),
    })
    //// @RequiresPermissions("sys:sysdept:page")
    public Result<PageUtil<SysDeptDto>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageUtil<SysDeptDto> page = sysDeptService.page(params);
        return Result.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("信息")
    //// @RequiresPermissions("sys:sysdept:info")
    public Result<SysDeptDto> get(@PathVariable("id") Long id) {
        SysDeptEntity data = sysDeptService.getById(id);
        SysDeptDto dto = ConvertUtils.sourceToTarget(data, SysDeptDto.class);
        return Result.ok(dto);
    }

    @PostMapping
    @ApiOperation("保存")
    // @LogOperation("保存")
    //// @RequiresPermissions("sys:sysdept:save")
    public Result save(@RequestBody SysDeptDto dto) {
        //效验数据
        SysDeptEntity data = ConvertUtils.sourceToTarget(dto, SysDeptEntity.class);
        sysDeptService.save(data);
        return Result.ok();
    }

    @PutMapping
    @ApiOperation("修改")
    // @LogOperation("修改")
    //// @RequiresPermissions("sys:sysdept:update")
    public Result update(@RequestBody SysDeptDto dto) {
        //效验数据
        SysDeptEntity data = ConvertUtils.sourceToTarget(dto, SysDeptEntity.class);
        sysDeptService.update(data);
        return Result.ok();
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改")
    // @LogOperation("保存或修改")
    //// @RequiresPermissions("sys:sysdept:saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SysDeptDto dto) {
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
    //// @RequiresPermissions("sys:sysdept:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        sysDeptService.removeByIds(Collections.singletonList(ids));
        return Result.ok();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    // @LogOperation("导出")
    // @RequiresPermissions("sys:sysdept:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SysDeptEntity> list = sysDeptService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, SysDeptExcel.class);
    }

}
