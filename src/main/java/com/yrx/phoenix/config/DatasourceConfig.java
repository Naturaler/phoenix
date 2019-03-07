package com.yrx.phoenix.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by r.x on 2019/3/7.
 */
@Configuration
public class DatasourceConfig {
    @Bean(name = "localDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdDatasource")
    @ConfigurationProperties(prefix = "spring.jd.datasource")
    public DataSource jdDatasource() {
        return DataSourceBuilder.create().build();
    }
}
