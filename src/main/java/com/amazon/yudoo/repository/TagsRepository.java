package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Integer> {
}
