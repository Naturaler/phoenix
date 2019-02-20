package com.yrx.phoenix.dao.extend;

/**
 * Created by r.x on 2019/2/20.
 */
public interface TagInfoExtetndMapper {

    // @SelectProvider(type= TagInfoSqlExtendProvider.class, method="getById")
    // @Results({
    //         @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
    //         @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
    //         @Result(column="outline", property="outline", jdbcType=JdbcType.VARCHAR),
    //         @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
    //         @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
    //         @Result(column="content_id", property="contentId", jdbcType=JdbcType.INTEGER)
    // })
    // Article getById(Integer id);
}
