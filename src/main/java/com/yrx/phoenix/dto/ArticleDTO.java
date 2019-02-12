package com.yrx.phoenix.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by r.x on 2019/2/12.
 */
@Data
public class ArticleDTO {
    private String title; // 标题
    private String content; // 内容
    private String category; // 类别
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 更新时间
}
