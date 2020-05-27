package com.diversity3.modules.test.controller;

import com.diversity3.common.Result;
import com.diversity3.common.enums.Constants;
import com.diversity3.common.page.PageUtil;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.common.utils.ExcelUtils;
import com.diversity3.modules.test.dto.TestDto;
import com.diversity3.modules.test.entity.Test;
import com.diversity3.modules.test.excel.TestExcel;
import com.diversity3.modules.test.service.TestService;
import com.diversity3.modules.test.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 22:33
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试", tags = "测试")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constants.PAGE_NO, value = "分页参数", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = Constants.PAGE_SIZE, value = "查询条件2", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER_BY_FIELD, value = "查询条件3", paramType = "query"),
            @ApiImplicitParam(name = Constants.ORDER, value = "查询条件4", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "time4", paramType = "query"),
    })
    public Result<PageUtil<Test>> t1(@ApiIgnore @RequestParam Map<String, Object> params) {
        System.out.println(params);
        PageUtil<Test> page = testService.page(params);
        return Result.of(page);
    }

    @GetMapping("/{id}")
    public Result<Test> info(@PathVariable Long id) {
        Test test = testService.getById(id);
        return Result.ok(test);
    }

    @PostMapping
    public Result save(@RequestBody TestDto testDto) {
        Test test = ConvertUtils.sourceToTarget(testDto, Test.class);
        testService.save(test);
        return Result.ok();
    }

    @PutMapping
    public Result update(@RequestBody TestDto testDto) {
        Test test = ConvertUtils.sourceToTarget(testDto, Test.class);
        testService.update(test);
        return Result.ok();
    }

    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody TestDto testDto) {
        if (testDto.getId() == null) {
            save(testDto);
        } else {
            update(testDto);
        }
        return Result.ok();
    }

    @DeleteMapping
    public Result delete(@RequestBody Long[] ids){
        testService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

    @GetMapping("/export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<Test> list = testService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, TestExcel.class);
    }

}
