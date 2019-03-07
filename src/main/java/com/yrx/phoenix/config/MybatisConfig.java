package com.yrx.phoenix.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by r.x on 2019/2/13.
 */
@Configuration
@MapperScan(basePackages = "com.yrx.phoenix.dao.local", sqlSessionFactoryRef = "localSqlSessionFactory")
public class MybatisConfig {
    @Resource(name = "localDataSource")
    // @Qualifier("localDataSource")
    private DataSource ds1;

    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory localSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1); // 使用titan数据源, 连接titan库
        return factoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(localSqlSessionFactory());
        return template;
    }
}
