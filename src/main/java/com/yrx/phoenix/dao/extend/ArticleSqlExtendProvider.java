package com.yrx.phoenix.dao.extend;

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
        sql.FROM("article limit " + limitCondition(pagination));
        return sql.toString();
    }

    private String limitCondition(Integer pagination) {
        return pagination * 10 + ", 10";
    }
}
