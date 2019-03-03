package com.yrx.phoenix.dto.category;

import lombok.Data;

import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
@Data
public class CategoryListDTO {
    private List<CategoryListDTO.CategoryDTO> categoryList;

    @Data
    public static class CategoryDTO {
        private String category;
        private Integer count;
    }
}
