package com.diversity3.modules.test.controller;

import com.diversity3.common.Result;
import com.diversity3.modules.test.dto.TestDto;
import com.diversity3.modules.test.entity.Test;
import com.diversity3.modules.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 22:33
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/t1")
    public Result t1(@Validated TestDto testDto) {
        List<Test> list = testService.list();
        return Result.of(list);
    }

}
