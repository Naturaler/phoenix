package com.yrx.phoenix.dao.remote.article.extend;

import com.yrx.phoenix.dao.remote.article.ArticleMapperRemote;
import com.yrx.phoenix.dto.archive.ArchiveListDTO;
import com.yrx.phoenix.dto.category.CategoryListDTO;
import com.yrx.phoenix.entity.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by r.x on 2019/2/17.
 * 扩展mapper
 */
public interface ArticleExtendMapperRemote extends ArticleMapperRemote {

    @SelectProvider(type= ArticleSqlExtendProviderRemote.class, method="listByPagination")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="outline", property="outline", jdbcType=JdbcType.VARCHAR),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="insert_time", property="insertTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="content_id", property="contentId", jdbcType=JdbcType.INTEGER)
    })
    List<Article> listByPagination(Integer pagination);

    @SelectProvider(type= ArticleSqlExtendProviderRemote.class, method="getById")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="outline", property="outline", jdbcType=JdbcType.VARCHAR),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="insert_time", property="insertTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="content_id", property="contentId", jdbcType=JdbcType.INTEGER)
    })
    Article getById(Integer id);

    @Select({
            "select * from article a join tag_info t on a.id = t.article_id where t.tag = #{tag,jdbcType=VARCHAR}"
    })
    List<Article> listByTag(@Param("tag") String tag);

    @SelectProvider(type= ArticleSqlExtendProviderRemote.class, method="listCategories")
    @Results({
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="c", property="count", jdbcType=JdbcType.INTEGER),
    })
    List<CategoryListDTO.CategoryDTO> listCategories();

    @SelectProvider(type= ArticleSqlExtendProviderRemote.class, method="listArticleOrderByYear")
    @Results({
            @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="insert_time", property="insertTime", jdbcType=JdbcType.TIMESTAMP),
    })
    List<ArchiveListDTO.ArchiveDTO> listArticleOrderByYear();
}
