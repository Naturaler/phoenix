package com.yrx.phoenix.demo;

import com.alibaba.fastjson.JSON;
import com.yrx.phoenix.entity.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by r.x on 2019/2/21.
 */
@Service
public class DemoService {

    @Async("asyncServiceExecutor")
    public void sout(Article article) {
        System.out.println(JSON.toJSON(article));
    }
}
