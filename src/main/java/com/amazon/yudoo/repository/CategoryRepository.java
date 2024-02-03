package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.Category;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findAll(Specification specification);
    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
    Optional<Category> findByName(@Param("categoryName") String categoryName);
}
