package com.amazon.yudoo.service;

import com.amazon.yudoo.exception.EntityExistException;
import com.amazon.yudoo.model.Category;
import com.amazon.yudoo.repository.CategoryRepository;
import com.amazon.yudoo.util.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    RandomStringGenerator randomStringGenerator;
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(RandomStringGenerator randomStringGenerator, CategoryRepository categoryRepository) {
        this.randomStringGenerator = randomStringGenerator;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> list(Integer page, Integer size, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category create(Category category) {
        try {
            category.setCategoryId(randomStringGenerator.random());
            return categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }

    @Override
    public List<Category> findAllByName(String name) {
        return null;
    }
}
