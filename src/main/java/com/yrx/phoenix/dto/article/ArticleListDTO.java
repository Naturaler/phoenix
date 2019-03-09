package com.yrx.phoenix.dto.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yrx.phoenix.entity.Article;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by r.x on 2019/2/12.
 */
@Data
public class ArticleListDTO {
    private List<ArticleDesc> articleDescList;
    private Integer amount; // 总数
    private String content; // tag? category?

    public ArticleListDTO() {
    }

    public ArticleListDTO(List<Article> articleList) {
        articleDescList = new ArrayList<>(articleList.size());
        for (Article article : articleList) {
            ArticleDesc desc = new ArticleDesc(article);
            articleDescList.add(desc);
        }
    }

    @Data
    public static class ArticleDesc {
        private Integer id; // article 主键
        private String title; // 标题
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date insertTime; // 创建时间
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date updateTime; // 更新时间
        private String outline; // 内容概要
        private String category; // 类别

        public ArticleDesc() {

        }

        public ArticleDesc(Article article) {
            this.id = article.getId();
            this.title = article.getTitle();
            this.insertTime = article.getInsertTime();
            this.updateTime = article.getUpdateTime();
            this.category = article.getCategory();
            this.outline = article.getOutline();
        }
    }
}
