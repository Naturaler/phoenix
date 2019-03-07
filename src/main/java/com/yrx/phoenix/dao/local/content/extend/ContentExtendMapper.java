package com.yrx.phoenix.dao.local.content.extend;

import com.yrx.phoenix.entity.Content;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

public interface ContentExtendMapper {

    @SelectProvider(type= ContentSqlExtendProvider.class, method="getById")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="insert_time", property="insertTime", jdbcType=JdbcType.TIMESTAMP),
    })
    Content getById(Integer id);
}