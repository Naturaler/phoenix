package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.ArticleDTO;
import com.yrx.phoenix.service.ArticleQueryService;
import com.yrx.phoenix.service.ArticleUpdateService;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by r.x on 2019/2/11.
 */
@RestController
@RequestMapping("/article")
public class ArticleCtrl {
    @Autowired
    private ArticleUpdateService updateService;
    @Autowired
    private ArticleQueryService queryService;

    /**
     * 分页加载文章列表：每页限制10条记录
     *
     * @param pagination 页码：从0开始
     */
    @GetMapping("/list")
    public Response<List<ArticleDTO>> list(Integer pagination) {
        if (pagination == null) {
            pagination = 0;
        }
        return queryService.list(pagination);
    }

    /**
     * 根据标题获取文章
     *
     * @param id 文章id
     * @return 文章
     */
    @GetMapping("/getArticleById")
    public Response<ArticleDTO> getArticleById(Integer id) {
        return queryService.getArticleById(id);
    }

    /**
     * 创建或修改文章
     *
     * @param articleVO 文章
     */
    @PostMapping("/createOUpdate")
    public Response<Integer> createOUpdate(@RequestBody ArticleVO articleVO) {
        return updateService.createOUpdate(articleVO);
    }
}
