package com.yrx.phoenix.service.category;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dao.local.article.extend.ArticleExtendMapper;
import com.yrx.phoenix.dto.category.CategoryListDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
@Service
@Slf4j
public class CategoryQueryService {
    @Autowired
    private ArticleExtendMapper articleMapper;

    public Response<CategoryListDTO> list() {
        List<CategoryListDTO.CategoryDTO> list = articleMapper.listCategories();
        CategoryListDTO dto = new CategoryListDTO();
        dto.setCategoryList(list);
        return Response.success(dto);
    }
}
