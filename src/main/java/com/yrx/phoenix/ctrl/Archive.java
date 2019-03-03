package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.archive.ArchiveListDTO;
import com.yrx.phoenix.service.archive.ArchiveQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by r.x on 2019/3/3.
 */
@RestController
@RequestMapping("/archive")
public class Archive {
    @Autowired
    private ArchiveQueryService archiveQueryService;

    /**
     * 按年份倒序加载所有文章
     */
    @GetMapping("/listArticleOrderByYear")
    public Response<ArchiveListDTO> listArticleOrderByYear() {
        return archiveQueryService.listArticleOrderByYear();
    }
}
