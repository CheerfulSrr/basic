package com.diversity3.modules.sys.controller;

import com.diversity3.common.Result;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.common.utils.ExcelUtils;
import com.diversity3.modules.sys.dto.SysUserDto;
import com.diversity3.modules.sys.entity.SysUserEntity;
import com.diversity3.modules.sys.excel.SysUserExcel;
import com.diversity3.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 用户
 * </p>
 *
 * @author: Greekn
 * @version: 1.0
 * @date: Created in 2020-05-29 11:15:46
 * @package: com.diversity3.sys.entity
 * @modified: Greekn
 * @description: 用户
 * @copyright: Copyright (c) 2020-05-29
 */
@RestController
@RequestMapping("/api/sys/sysuser")
@Api(value = "用户", tags = "用户")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.PAGE_NO, value = "分页参数", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = Constants.PAGE_SIZE, value = "查询条件2", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER_BY_FIELD, value = "查询条件3", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER, value = "查询条件4", paramType = "query"),
    })

    public Result<PageUtil<SysUserDto>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageUtil<SysUserDto> page = sysUserService.page(params);
        return Result.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("信息")
    public Result<SysUserDto> get(@PathVariable("id") Long id) {
        SysUserEntity data = sysUserService.getById(id);
        SysUserDto dto = ConvertUtils.sourceToTarget(data, SysUserDto.class);
        return Result.ok(dto);
    }

    @PostMapping
    @ApiOperation("保存")
    public Result save(@RequestBody SysUserDto dto) {
        SysUserEntity data = ConvertUtils.sourceToTarget(dto, SysUserEntity.class);
        sysUserService.save(data);
        return Result.ok();
    }

    @PutMapping
    @ApiOperation("修改")
    public Result update(@RequestBody SysUserDto dto) {
        SysUserEntity data = ConvertUtils.sourceToTarget(dto, SysUserEntity.class);
        sysUserService.update(data);
        return Result.ok();
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改")
    public Result saveOrUpdate(@RequestBody SysUserDto dto) {
        if (dto.getId() == null) {
            save(dto);
        } else {
            update(dto);
        }
        return Result.ok();
    }

    @DeleteMapping
    @ApiOperation("删除")
    public Result delete(@RequestBody Long[] ids) {
        sysUserService.removeByIds(Collections.singletonList(ids));
        return Result.ok();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SysUserEntity> list = sysUserService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, SysUserExcel.class);
    }

}
