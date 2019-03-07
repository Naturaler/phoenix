package com.yrx.phoenix.service.archive;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.local.article.extend.ArticleExtendMapper;
import com.yrx.phoenix.dto.archive.ArchiveListDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
@Service
@Slf4j
public class ArchiveQueryService {
    @Autowired
    private ArticleExtendMapper articleMapper;

    public Response<ArchiveListDTO> listArticleOrderByYear() {
        List<ArchiveListDTO.ArchiveDTO> list = articleMapper.listArticleOrderByYear();
        ArchiveListDTO dto = new ArchiveListDTO();
        dto.setArchiveList(list);
        return Response.success(dto);
    }
}
