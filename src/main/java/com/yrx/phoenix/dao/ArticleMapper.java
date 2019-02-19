package com.yrx.phoenix.dao;

import com.yrx.phoenix.entity.Article;
import com.yrx.phoenix.entity.ArticleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @SelectProvider(type=ArticleSqlProvider.class, method="countByExample")
    long countByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @DeleteProvider(type=ArticleSqlProvider.class, method="deleteByExample")
    int deleteByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @Insert({
        "insert into article (title, outline, ",
        "category, update_time, ",
        "insert_time, content_id)",
        "values (#{title,jdbcType=VARCHAR}, #{outline,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{insertTime,jdbcType=TIMESTAMP}, #{contentId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @InsertProvider(type=ArticleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @SelectProvider(type=ArticleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="outline", property="outline", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="insert_time", property="insertTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content_id", property="contentId", jdbcType=JdbcType.INTEGER)
    })
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @UpdateProvider(type=ArticleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Tue Feb 19 19:43:36 CST 2019
     */
    @UpdateProvider(type=ArticleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);
}