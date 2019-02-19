package com.yrx.phoenix.dao.extend;

import com.yrx.phoenix.entity.Article;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by r.x on 2019/2/17.
 * 扩展mapper
 */
public interface ArticleExtendMapper {

    @SelectProvider(type= ArticleSqlExtendProvider.class, method="listByPagination")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="outline", property="outline", jdbcType=JdbcType.VARCHAR),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="content_id", property="contentId", jdbcType=JdbcType.INTEGER)
    })
    List<Article> listByPagination(Integer pagination);

    @SelectProvider(type= ArticleSqlExtendProvider.class, method="getById")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="outline", property="outline", jdbcType=JdbcType.VARCHAR),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="content_id", property="contentId", jdbcType=JdbcType.INTEGER)
    })
    Article getById(Integer id);
}
