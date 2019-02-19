package com.yrx.phoenix.service;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.extend.ArticleExtendMapper;
import com.yrx.phoenix.dao.extend.ContentExtendMapper;
import com.yrx.phoenix.dto.ArticleDTO;
import com.yrx.phoenix.entity.Article;
import com.yrx.phoenix.entity.ArticleExample;
import com.yrx.phoenix.entity.Content;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.x on 2019/2/19.
 * 查询服务
 */
@Service
@Slf4j
public class ArticleQueryService {
    @Autowired
    private ArticleExtendMapper articleExtendMapper;
    @Autowired
    private ContentExtendMapper contentExtendMapper;

    public Response<List<ArticleDTO>> list(Integer pagination) {
        List<Article> articles = articleExtendMapper.listByPagination(pagination);
        List<ArticleDTO> dtos = new ArrayList<>(articles.size());
        articles.forEach(article -> dtos.add(new ArticleDTO(article)));
        return Response.success(dtos);
    }

    public Response<ArticleDTO> getArticleById(Integer id) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        Article article = articleExtendMapper.getById(id);
        Content content = contentExtendMapper.getById(article.getContentId());
        ArticleDTO dto = new ArticleDTO(article);
        dto.setContent(content.getContent());
        return Response.success(dto);
    }
}
