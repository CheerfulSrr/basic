package com.diversity3.modules.sys.controller;

import com.diversity3.common.Result;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.common.utils.ExcelUtils;
import com.diversity3.modules.sys.dto.SysDictDto;
import com.diversity3.modules.sys.entity.SysDictEntity;
import com.diversity3.modules.sys.excel.SysDictExcel;
import com.diversity3.modules.sys.service.SysDictService;
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
@RestController
@RequestMapping("/api/sys/sysdict")
@Api(value = "字典表", tags = "字典表")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.PAGE_NO, value = "分页参数", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = Constants.PAGE_SIZE, value = "查询条件2", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER_BY_FIELD, value = "查询条件3", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER, value = "查询条件4", paramType = "query"),
    })
    //// @RequiresPermissions("sys:sysdict:page")
    public Result<PageUtil<SysDictDto>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageUtil<SysDictDto> page = sysDictService.page(params);
        return Result.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("信息")
    //// @RequiresPermissions("sys:sysdict:info")
    public Result<SysDictDto> get(@PathVariable("id") Long id) {
        SysDictEntity data = sysDictService.getById(id);
        SysDictDto dto = ConvertUtils.sourceToTarget(data, SysDictDto.class);
        return Result.ok(dto);
    }

    @PostMapping
    @ApiOperation("保存")
    // @LogOperation("保存")
    //// @RequiresPermissions("sys:sysdict:save")
    public Result save(@RequestBody SysDictDto dto) {
        //效验数据
        SysDictEntity data = ConvertUtils.sourceToTarget(dto, SysDictEntity.class);
        sysDictService.save(data);
        return Result.ok();
    }

    @PutMapping
    @ApiOperation("修改")
    // @LogOperation("修改")
    //// @RequiresPermissions("sys:sysdict:update")
    public Result update(@RequestBody SysDictDto dto) {
        //效验数据
        SysDictEntity data = ConvertUtils.sourceToTarget(dto, SysDictEntity.class);
        sysDictService.update(data);
        return Result.ok();
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改")
    // @LogOperation("保存或修改")
    //// @RequiresPermissions("sys:sysdict:saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SysDictDto dto) {
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
    //// @RequiresPermissions("sys:sysdict:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        sysDictService.removeByIds(Collections.singletonList(ids));
        return Result.ok();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    // @LogOperation("导出")
    // @RequiresPermissions("sys:sysdict:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SysDictEntity> list = sysDictService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, SysDictExcel.class);
    }

}
