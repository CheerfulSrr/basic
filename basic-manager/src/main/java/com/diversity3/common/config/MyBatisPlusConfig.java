package com.diversity3.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Greekn
 * @version 0.1
 * @date 2020-05-26 13:18
 */

@Configuration
@MapperScan("com.diversity3.modules.*.dao")
public class MyBatisPlusConfig {

}
