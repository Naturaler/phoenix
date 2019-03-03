package com.yrx.phoenix.service;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.article.ArticleMapper;
import com.yrx.phoenix.dao.content.ContentMapper;
import com.yrx.phoenix.dao.tag.TagInfoMapper;
import com.yrx.phoenix.entity.*;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private TagInfoMapper tagInfoMapper;

    @Transactional
    public Response<Integer> createOUpdate(ArticleVO articleVO) {
        Content content = convertVo2ContentEntity(articleVO);
        Article article = convertVo2ArticleEntity(articleVO);
        Integer articleId;
        if (articleVO.getId() == null) {
            articleId = insertArticle(content, article);
        } else {
            articleId = updateArticle(articleVO, content, article);
        }
        deleteNInsertTag(articleVO, articleId);
        return Response.success(articleId);
    }

    private void deleteNInsertTag(ArticleVO articleVO, Integer articleId) {
        // 删除tag
        TagInfoExample tagInfoExample = new TagInfoExample();
        TagInfoExample.Criteria criteria = tagInfoExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        tagInfoMapper.deleteByExample(tagInfoExample);
        // 插入tag
        String[] tags = articleVO.getTags().split(",");
        for (String tag : tags) {
            TagInfo tagInfo = new TagInfo();
            tagInfo.setArticleId(articleId);
            tagInfo.setUpdateTime(new Date());
            tagInfo.setInsertTime(new Date());
            tagInfo.setTag(tag);
            tagInfoMapper.insert(tagInfo);
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

    private Integer updateArticle(ArticleVO articleVO, Content content, Article article) {
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria contentCriteria = contentExample.createCriteria();
        contentCriteria.andIdEqualTo(articleVO.getContentId());
        contentMapper.updateByExample(content, contentExample);

        article.setContentId(articleVO.getContentId());
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria articleCriteria = articleExample.createCriteria();
        articleCriteria.andIdEqualTo(articleVO.getId());
        articleMapper.updateByExample(article, articleExample);
        return articleVO.getId();
    }

    private Integer insertArticle(Content content, Article article) {
        content.setInsertTime(new Date());
        contentMapper.insert(content);

        article.setContentId(content.getId());
        article.setInsertTime(new Date());
        articleMapper.insert(article);
        return article.getId();
    }


}
