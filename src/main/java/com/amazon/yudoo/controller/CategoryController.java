package com.amazon.yudoo.controller;

import com.amazon.yudoo.model.Category;
import com.amazon.yudoo.model.response.PagingResponse;
import com.amazon.yudoo.service.CategoryService;
import com.amazon.yudoo.util.UrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlMapping.BASE + UrlMapping.CATEGORY)
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    ResponseEntity<PagingResponse<Category>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "categoryId") String sortBy,
            @RequestParam(defaultValue = "DESC") String direction
    ){
        Page<Category> categories = categoryService.list(page, size, sortBy, direction);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Success get categories list", categories));

    }
}
