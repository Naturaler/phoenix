package com.yrx.phoenix.service;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.ArticleMapper;
import com.yrx.phoenix.dao.ContentMapper;
import com.yrx.phoenix.entity.Article;
import com.yrx.phoenix.entity.ArticleExample;
import com.yrx.phoenix.entity.Content;
import com.yrx.phoenix.entity.ContentExample;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Created by r.x on 2019/2/14.
 * 插入和更新服务
 */
@Service
public class ArticleUpdateService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ContentMapper contentMapper;

    public Response<Integer> createOUpdate(ArticleVO articleVO) {
        Content content = convertVo2ContentEntity(articleVO);
        Article article = convertVo2ArticleEntity(articleVO);
        if (articleVO.getId() == null) {
            return insertArticle(content, article);
        } else {
            return updateArticle(articleVO, content, article);
        }
    }

    private Article convertVo2ArticleEntity(ArticleVO articleVO) {
        Article article = new Article();
        article.setTitle(articleVO.getTitle());
        if (articleVO.getPlainText().length() > 500) {
            article.setOutline(articleVO.getPlainText().substring(0, 500));
        } else {
            article.setOutline(articleVO.getPlainText());
        }
        article.setCategory(articleVO.getCategory());
        article.setUpdateTime(new Date());
        return article;
    }

    private Content convertVo2ContentEntity(ArticleVO articleVO) {
        Content content = new Content();
        content.setContent(articleVO.getContent());
        content.setUpdateTime(new Date());
        return content;
    }

    private Response<Integer> updateArticle(ArticleVO articleVO, Content content, Article article) {
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria contentCriteria = contentExample.createCriteria();
        contentCriteria.andIdEqualTo(articleVO.getContentId());
        contentMapper.updateByExample(content, contentExample);

        article.setContentId(articleVO.getContentId());
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria articleCriteria = articleExample.createCriteria();
        articleCriteria.andIdEqualTo(articleVO.getId());
        articleMapper.updateByExample(article, articleExample);
        return Response.success(articleVO.getId());
    }

    private Response<Integer> insertArticle(Content content, Article article) {
        content.setInsertTime(new Date());
        contentMapper.insert(content);

        article.setContentId(content.getId());
        article.setInsertTime(new Date());
        articleMapper.insert(article);
        return Response.success(article.getId());
    }


}
