package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by r.x on 2019/2/11.
 */
@RestController
@RequestMapping("/edit")
public class ArticleCtrl {

    @GetMapping("/getArticleByTitle")
    public ArticleVO getArticleByTitle(String title) {
        ArticleVO vo = new ArticleVO();
        vo.setTitle("title");
        vo.setContent("node");
        vo.setCategory("修仙");
        vo.setCreateTime(new Date());
        vo.setUpdateTime(new Date());
        return vo;
    }
}
