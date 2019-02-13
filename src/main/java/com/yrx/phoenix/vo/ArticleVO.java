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
    private String content; // 带html标签的内容
    private String plainText; // 带段落格式的内容
    private String category; // 类别
    private String[] tags; // 标签数组
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime; // 更新时间
}
