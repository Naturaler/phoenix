package com.yrx.phoenix.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by r.x on 2019/2/13.
 */
@Configuration
@MapperScan(basePackages = "com.yrx.phoenix.dao.remote", sqlSessionFactoryRef = "remoteSqlSessionFactory")
public class MybatisRemoteConfig {
    @Autowired
    @Qualifier("jdDatasource")
    private DataSource ds1;

    @Bean(name = "remoteSqlSessionFactory")
    public SqlSessionFactory remoteSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1); // 使用titan数据源, 连接titan库
        return factoryBean.getObject();
    }

    @Bean(name = "remoteSqlSessionTemplate")
    public SqlSessionTemplate remoteSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(remoteSqlSessionFactory());
        return template;
    }
}
