package com.yrx.phoenix.service;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.ArticleMapper;
import com.yrx.phoenix.dao.extend.ArticleExtendMapper;
import com.yrx.phoenix.dto.ArticleDTO;
import com.yrx.phoenix.entity.Article;
import com.yrx.phoenix.entity.ArticleExample;
import com.yrx.phoenix.util.MD5Util;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by r.x on 2019/2/14.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper mapper;
    @Autowired
    private ArticleExtendMapper extendMapper;

    public Response<List<ArticleDTO>> list(Integer pagination) {
        List<Article> articles = extendMapper.listByPagination(pagination);
        List<ArticleDTO> dtos = new ArrayList<>(articles.size());
        articles.forEach(article -> dtos.add(new ArticleDTO(article)));
        return Response.success(dtos);
    }

    public Response<Integer> createOUpdate(ArticleVO articleVO) {
        Article article = new Article();
        article.setTitle(article.getTitle());
        article.setOutline(articleVO.getPlainText().substring(0, 500));
        article.setCategory(articleVO.getCategory());
        article.setRowkey(MD5Util.getMD5(articleVO.getTitle()));
        article.setUpdateTime(new Date());
        int id = mapper.insert(article);
        return Response.success(id);
    }

    public Response<ArticleDTO> getArticleById(Integer id) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Article> articles = mapper.selectByExample(example);
        ArticleDTO dto = new ArticleDTO(articles.get(0));
        dto.setContent("");
        return Response.success(dto);
    }
}
