package com.yrx.phoenix.dao.local.tag.extend;

import com.yrx.phoenix.dao.local.tag.TagInfoMapper;
import com.yrx.phoenix.dto.tag.TagListDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
public interface TagInfoExtendMapper extends TagInfoMapper {

    @SelectProvider(type = TagInfoExtendSqlProvider.class, method = "list")
    @Results({
            @Result(column = "tag", property = "tag", jdbcType = JdbcType.VARCHAR),
            @Result(column = "c", property = "count", jdbcType = JdbcType.INTEGER),
    })
    List<TagListDTO.TagDTO> list();
}
