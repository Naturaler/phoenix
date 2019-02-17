package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.ArticleDTO;
import com.yrx.phoenix.service.ArticleService;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by r.x on 2019/2/11.
 */
@RestController
@RequestMapping("/article")
public class ArticleCtrl {
    @Autowired
    private ArticleService service;

    /**
     * 分页加载文章列表：每页限制10条记录
     * @param pagination 页码：从0开始
     */
    @GetMapping("/list")
    public Response<List<ArticleDTO>> list(Integer pagination) {
        return service.list(pagination);
    }

    /**
     * 根据标题获取文章
     * @param id 文章id
     * @return 文章
     */
    @GetMapping("/getArticleById")
    public Response<ArticleDTO> getArticleById(Integer id) {
        return service.getArticleById(id);
    }

    /**
     * 创建或修改文章
     * @param articleVO 文章
     */
    @PostMapping("/createOUpdate")
    public Response createOUpdate(ArticleVO articleVO) {
        return service.createOUpdate(articleVO);
    }
}
