package com.yrx.phoenix.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by r.x on 2019/2/9.
 */
@Data
@Builder
public class ArticleVO extends BaseVO {
    private Integer id; // 主键id
    private Integer contentId; // 文章内容id
    private String title; // 标题
    private String content; // 带html标签的内容
    private String plainText; // 带段落格式的内容
    private String category; // 类别
    private String tags; // 标签
}
