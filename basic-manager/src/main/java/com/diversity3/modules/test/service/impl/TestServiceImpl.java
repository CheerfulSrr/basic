package com.diversity3.modules.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diversity3.modules.test.dao.TestDao;
import com.diversity3.modules.test.entity.Test;
import com.diversity3.modules.test.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 16:05
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Test> implements TestService {
}
