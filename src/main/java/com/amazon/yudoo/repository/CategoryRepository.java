package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.Category;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findAll(Specification specification);
}
