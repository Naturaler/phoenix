package com.yrx.phoenix.dto;

import com.yrx.phoenix.entity.Article;
import lombok.Data;

/**
 * Created by r.x on 2019/2/12.
 */
@Data
public class ArticleDTO {
    private Article article;
    private String content; // 内容
    private String tags; // 标签
    private Integer amount; // 总数

    public ArticleDTO() {
    }

    public ArticleDTO(Article article) {
        this.article = article;
    }
}
