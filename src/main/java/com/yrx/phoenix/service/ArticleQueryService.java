package com.yrx.phoenix.service;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.TagInfoMapper;
import com.yrx.phoenix.dao.extend.ArticleExtendMapper;
import com.yrx.phoenix.dao.extend.ContentExtendMapper;
import com.yrx.phoenix.dto.ArticleDTO;
import com.yrx.phoenix.dto.ArticleListDTO;
import com.yrx.phoenix.entity.*;
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
    @Autowired
    private TagInfoMapper tagInfoMapper;

    public Response<ArticleListDTO> list(Integer pagination) {
        List<Article> articles = articleExtendMapper.listByPagination(pagination);
        ArticleListDTO dto = new ArticleListDTO(articles);
        Long amount = articleExtendMapper.countByExample(new ArticleExample());
        dto.setAmount(amount.intValue());
        return Response.success(dto);
    }

    public Response<ArticleDTO> getById(Integer id) {
        Article article = getArticleById(id);
        Content content = getContentByContentId(article.getContentId());
        List<TagInfo> tagInfoList = getTagInfoListByArticleId(article.getId());
        ArticleDTO dto = new ArticleDTO(article, tagInfoList, content.getContent());
        return Response.success(dto);
    }

    private List<TagInfo> getTagInfoListByArticleId(Integer articleId) {
        TagInfoExample tagInfoExample = new TagInfoExample();
        TagInfoExample.Criteria criteria = tagInfoExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        return tagInfoMapper.selectByExample(tagInfoExample);
    }

    private Content getContentByContentId(Integer contentId) {
        return contentExtendMapper.getById(contentId);
    }

    private Article getArticleById(Integer id) {
        return articleExtendMapper.getById(id);
    }
}
