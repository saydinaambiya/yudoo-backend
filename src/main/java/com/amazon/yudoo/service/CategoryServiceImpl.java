package com.amazon.yudoo.service;

import com.amazon.yudoo.exception.EntityExistException;
import com.amazon.yudoo.exception.NotFoundException;
import com.amazon.yudoo.model.Category;
import com.amazon.yudoo.model.request.CategoryRequest;
import com.amazon.yudoo.repository.CategoryRepository;
import com.amazon.yudoo.repository.spec.SearchCriteria;
import com.amazon.yudoo.repository.spec.Spec;
import com.amazon.yudoo.util.QueryOperator;
import com.amazon.yudoo.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    RandomStringGenerator randomStringGenerator;

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> list(Integer page, Integer size, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category create(CategoryRequest categoryRequest) {
        try {
            Category category = new Category();
            category.setCategoryId(randomStringGenerator.random());
            category.setCategoryName(categoryRequest.getCategoryName());
            category.setCreatedAt(LocalDateTime.now());
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }

    @Override
    public List<Category> listByName(String name) {
        SearchCriteria searchCriteria = new SearchCriteria()
                .setOperator(QueryOperator.LIKE)
                .setKey("categoryName")
                .setValue(name);
        Specification<Category> spec = new Spec<Category>().findBy(searchCriteria);
        return categoryRepository.findAll(spec);
    }

    @Override
    public Category getByName(String categoryName) {
        Optional<Category> category = categoryRepository.findByName(categoryName);
        if (category.isEmpty()) {
            throw new NotFoundException("Category not found");
        }
        return category.get();
    }

    @Override
    public void update(CategoryRequest categoryRequest) {

    }
}
