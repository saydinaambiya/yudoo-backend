package com.amazon.yudoo.service;

import com.amazon.yudoo.model.Category;
import com.amazon.yudoo.model.request.CategoryRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Page<Category> list(Integer page, Integer size, String sortBy, String direction);
    Category create(CategoryRequest categoryRequest);
    List<Category> listByName(String name);
    void update(CategoryRequest categoryRequest);
    Category getByName(String categoryName);
}
