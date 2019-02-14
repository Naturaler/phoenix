package com.yrx.phoenix.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by r.x on 2019/2/13.
 */
@Configuration
@MapperScan(basePackages = "com.yrx.phoenix.dao")
public class MybatisConfig {

}
