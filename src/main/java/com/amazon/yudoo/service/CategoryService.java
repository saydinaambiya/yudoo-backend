package com.amazon.yudoo.service;

import com.amazon.yudoo.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Page<Category> list(Integer page, Integer size, String sortBy, String direction);
    Category create(Category category);
    List<Category> findAllByName(String name);
}
