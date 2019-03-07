package com.yrx.phoenix.dao.local.article.extend;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by r.x on 2019/2/17.
 */
public class ArticleSqlExtendProvider {

    public String listByPagination(Integer pagination) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("title");
        sql.SELECT("outline");
        sql.SELECT("category");
        sql.SELECT("update_time");
        sql.SELECT("insert_time");
        sql.SELECT("content_id");
        sql.FROM("article limit " + limitCondition(pagination));
        return sql.toString();
    }

    public String getById(Integer id) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("title");
        sql.SELECT("outline");
        sql.SELECT("category");
        sql.SELECT("update_time");
        sql.SELECT("insert_time");
        sql.SELECT("content_id");
        sql.FROM("article");
        sql.WHERE("id = " + id);
        return sql.toString();
    }

    // select category, count(1) as c from article category
    public String listCategories() {
        SQL sql = new SQL();
        sql.SELECT("category");
        sql.SELECT("count(1) as c");
        sql.FROM("article");
        sql.GROUP_BY("category");
        return sql.toString();
    }

    // select substr(insert_time, 1, 4) year, title, insert_time from article group by year, title, insert_time order by insert_time desc;
    public String listArticleOrderByYear() {
        SQL sql = new SQL();
        sql.SELECT("substr(insert_time, 1, 4) as year");
        sql.SELECT("title");
        sql.SELECT("insert_time");
        sql.FROM("article");
        sql.GROUP_BY("year");
        sql.GROUP_BY("title");
        sql.GROUP_BY("insert_time");
        sql.ORDER_BY("insert_time desc");
        return sql.toString();
    }
    private String limitCondition(Integer pagination) {
        return pagination * 10 + ", 10";
    }
}
