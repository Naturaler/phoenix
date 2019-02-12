package com.yrx.phoenix.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by r.x on 2019/2/9.
 */
@Data
public class ArticleVO {
    private String title; // 标题
    private String content; // 内容
    private String category; // 类别
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}
