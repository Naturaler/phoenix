package com.yrx.phoenix.service;

import com.yrx.phoenix.dao.ArticleMapper;
import com.yrx.phoenix.entity.Article;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by r.x on 2019/2/14.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper mapper;

    public void createOUpdate(ArticleVO articleVO) {
        Article article = new Article();
        article.setCategory("修仙");
        article.setTitle("代码整洁之道");
        article.setOutline("概述");
        article.setRowkey("rowkey");
        article.setUpdateTime(new Date());
        mapper.insert(article);
    }
}
