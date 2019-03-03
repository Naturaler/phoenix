package com.yrx.phoenix.ctrl;

import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.dto.category.CategoryListDTO;
import com.yrx.phoenix.service.category.CategoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by r.x on 2019/3/3.
 */
@RestController
@RequestMapping("/category")
public class CategoryCtrl {

    @Autowired
    private CategoryQueryService categoryQueryService;

    /**
     * 加载所有类别
     */
    @GetMapping("/list")
    public Response<CategoryListDTO> list() {
        return categoryQueryService.list();
    }
}
