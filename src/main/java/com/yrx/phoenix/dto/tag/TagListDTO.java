package com.yrx.phoenix.dto.tag;

import lombok.Data;

import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
@Data
public class TagListDTO {
    private List<TagDTO> tagList;

    @Data
    public static class TagDTO {
        private String tag;
        private Integer count;
    }
}
