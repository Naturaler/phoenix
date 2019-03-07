package com.yrx.phoenix.dao.remote.tag.extend;

import com.yrx.phoenix.dao.remote.tag.TagInfoSqlProviderRemote;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by r.x on 2019/3/3.
 */
public class TagInfoExtendSqlProviderRemoteRemote extends TagInfoSqlProviderRemote {

    public String list() {
        SQL sql = new SQL();
        sql.SELECT("tag");
        sql.SELECT("count(1) as c");
        sql.FROM("tag_info");
        sql.GROUP_BY("tag");
        return sql.toString();
    }

}
