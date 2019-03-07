package com.yrx.phoenix.dao.local.tag.extend;

import com.yrx.phoenix.dao.local.tag.TagInfoSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by r.x on 2019/3/3.
 */
public class TagInfoExtendSqlProvider extends TagInfoSqlProvider {

    public String list() {
        SQL sql = new SQL();
        sql.SELECT("tag");
        sql.SELECT("count(1) as c");
        sql.FROM("tag_info");
        sql.GROUP_BY("tag");
        return sql.toString();
    }

}
