package com.yrx.phoenix.demo;

import com.yrx.phoenix.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by r.x on 2019/2/21.
 */
@RestController
@RequestMapping("/demo")
public class DemoCtrl {
    @Autowired
    private DemoService service;

    @GetMapping("/async")
    public String async() {
        for (int i = 0; i < 1000000; i++) {
            Article article = new Article();
            article.setInsertTime(new Date());
            article.setContentId(i);
            article.setUpdateTime(new Date());
            article.setTitle("title[" + i + "]");
            article.setOutline("outline["+i+"]");
            article.setId(i);
            service.sout(article);
        }
        return "abc";
    }
}
