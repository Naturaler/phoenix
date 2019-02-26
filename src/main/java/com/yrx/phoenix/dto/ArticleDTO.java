package com.yrx.phoenix.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yrx.phoenix.entity.Article;
import com.yrx.phoenix.entity.TagInfo;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by r.x on 2019/2/21.
 */
@Data
public class ArticleDTO {
    private Integer id;
    private String title;
    private String category;
    private String tags;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public ArticleDTO() {

    }

    public ArticleDTO(Article article, List<TagInfo> tagInfoList, String content) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.category = article.getCategory();
        this.tags = convertTagList2Tags(tagInfoList);
        this.content = content;
        this.updateTime = article.getUpdateTime();
    }

    private String convertTagList2Tags(List<TagInfo> tagInfoList) {
        StringJoiner joiner = new StringJoiner(",");
        tagInfoList.forEach(tag -> joiner.add(tags));
        return joiner.toString();
    }
}
