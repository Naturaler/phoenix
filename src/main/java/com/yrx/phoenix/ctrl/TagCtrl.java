package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.tag.TagListDTO;
import com.yrx.phoenix.service.tag.TagQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by r.x on 2019/3/3.
 */
@RestController
@RequestMapping("/tag")
public class TagCtrl {
    @Autowired
    private TagQueryService tagQueryService;

    /**
     * 加载所有标签
     */
    @GetMapping("/list")
    public Response<TagListDTO> list() {
        return tagQueryService.list();
    }
}
