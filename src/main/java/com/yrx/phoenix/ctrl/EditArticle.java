package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.service.HtmlHelper;
import com.yrx.phoenix.vo.ArticleVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by r.x on 2019/2/9.
 */
@RestController
@RequestMapping("/edit")
public class EditArticle {

    // @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/article")
    public String edit(@RequestBody ArticleVO articleVO) {
        System.out.println(articleVO);
        System.out.println(HtmlHelper.generateHtml(articleVO.getTitle(), articleVO.getContent()));
        return "success";
    }
}
