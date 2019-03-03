package com.yrx.phoenix.service.tag;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.tag.extend.TagInfoExtendMapper;
import com.yrx.phoenix.dto.tag.TagListDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
@Service
@Slf4j
public class TagQueryService {
    @Autowired
    private TagInfoExtendMapper tagInfoMapper;

    public Response<TagListDTO> list() {
        List<TagListDTO.TagDTO> list = tagInfoMapper.list();
        TagListDTO dto = new TagListDTO();
        dto.setTagList(list);
        return Response.success(dto);
    }
}
