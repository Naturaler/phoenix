package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.article.ArticleDTO;
import com.yrx.phoenix.dto.article.ArticleListDTO;
import com.yrx.phoenix.service.ArticleQueryService;
import com.yrx.phoenix.service.ArticleUpdateService;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Response<ArticleListDTO> list(Integer pagination) {
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
    @GetMapping("/getById")
    public Response<ArticleDTO> getById(Integer id) {
        return queryService.getById(id);
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

    /**
     * 根据标签查询文章
     *
     * @param tag 标签
     */
    @GetMapping("/listByTag")
    public Response<ArticleListDTO> listByTag(String tag) {
        return queryService.listByTag(tag);
    }

    /**
     * 根据类别查询文章
     *
     * @param category 类别
     */
    @GetMapping("/listByCategory")
    public Response<ArticleListDTO> listByCategory(String category) {
        return queryService.listByCategory(category);
    }
}
