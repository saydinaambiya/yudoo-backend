package com.amazon.yudoo.controller;

import com.amazon.yudoo.model.Category;
import com.amazon.yudoo.model.request.CategoryRequest;
import com.amazon.yudoo.model.response.ErrorResponse;
import com.amazon.yudoo.model.response.PagingResponse;
import com.amazon.yudoo.model.response.SuccessResponse;
import com.amazon.yudoo.service.CategoryService;
import com.amazon.yudoo.util.UrlMapping;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ) {
        Page<Category> categories = categoryService.list(page, size, sortBy, direction);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Success get categories list", categories));

    }

    @PostMapping
    ResponseEntity createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        try {
            Category newCategory = categoryService.create(categoryRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success create category", newCategory));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(Integer.toString(HttpStatus.BAD_REQUEST.value()), e.getMessage()));
        }
    }

    @GetMapping(params = {"categoryName"})
    ResponseEntity getAllByName(@Valid @RequestParam("categoryName") String name) {
        List<Category> categoryList = categoryService.listByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get all by name", categoryList));
    }

    @GetMapping("/{categoryName}")
    ResponseEntity getByName(@PathVariable("categoryName") String categoryName) {
        Category category = categoryService.getByName(categoryName);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<Category>("Success get category " + categoryName, category));
    }

}
