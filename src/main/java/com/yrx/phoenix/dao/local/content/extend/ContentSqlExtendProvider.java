package com.yrx.phoenix.dao.local.content.extend;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by r.x on 2019/2/19.
 */
public class ContentSqlExtendProvider {

    public String getById(Integer id) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("content");
        sql.SELECT("update_time");
        sql.SELECT("insert_time");
        sql.FROM("content");
        sql.WHERE("id = " + id);
        return sql.toString();
    }
}
