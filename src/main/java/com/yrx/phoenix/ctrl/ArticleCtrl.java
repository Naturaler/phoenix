package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.ArticleDTO;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by r.x on 2019/2/11.
 */
@RestController
@RequestMapping("/article")
public class ArticleCtrl {

    /**
     * 分页加载文章列表：每页限制10条记录
     * @param pagination 页码
     */
    @GetMapping("/list")
    public Response<List<ArticleDTO>> list(Integer pagination) {
        ArticleDTO dto = new ArticleDTO();
        dto.setTitle("title");
        dto.setContent("node");
        dto.setCategory("修仙");
        dto.setUpdateTime(new Date());
        List<ArticleDTO> dtos = new ArrayList<>(1);
        dtos.add(dto);

        Response<List<ArticleDTO>> response = Response.success();
        response.setResult(dtos);
        return response;
    }

    /**
     * 根据标题获取文章
     * @param id 文章id
     * @return 文章
     */
    @GetMapping("/getArticleByTitle")
    public Response getArticleByTitle(Integer id) {
        ArticleDTO dto = new ArticleDTO();
        dto.setTitle("title");
        dto.setContent("node");
        dto.setCategory("修仙");
        dto.setUpdateTime(new Date());

        Response<ArticleDTO> response = Response.success();
        response.setResult(dto);
        return response;
    }

    /**
     * 创建或修改文章
     * @param articleVO 文章
     */
    @PostMapping("/createOUpdate")
    public Response createOUpdate(ArticleVO articleVO) {
        return Response.success();
    }
}
