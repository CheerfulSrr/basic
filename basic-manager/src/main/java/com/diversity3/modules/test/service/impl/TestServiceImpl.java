package com.diversity3.modules.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.diversity3.common.base.impl.BaseServiceImpl;
import com.diversity3.common.utils.ConvertUtils;
import com.diversity3.modules.test.dao.TestDao;
import com.diversity3.modules.test.entity.Test;
import com.diversity3.modules.test.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 自定义wrapper
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 16:05
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<TestDao, Test> implements TestService {

    @Override
    public LambdaQueryWrapper<Test> toQueryWrapper(Map<String, Object> params) {
        LambdaQueryWrapper<Test> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Test::getName, params.get("name"));
        return wrapper;
    }

    @Override
    public LambdaUpdateWrapper<Test> toUpdateWrapper(Test entity) {
        LambdaUpdateWrapper<Test> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(Test::getId, entity.getId());
        return wrapper;
    }

    @Override
    public List<Test> toTarget(List<Test> source) {
        return ConvertUtils.sourceToTarget(source, Test.class);
    }

    @Override
    public Test toTarget(Test source) {
        return ConvertUtils.sourceToTarget(source, Test.class);
    }

}
