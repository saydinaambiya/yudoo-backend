package com.amazon.yudoo.service;

import com.amazon.yudoo.model.Tags;

import java.util.List;
import java.util.Optional;

public interface TagsService {
    Tags create(Tags newTags);

    void updateById(Integer tagsId, Integer userId);

    void deleteById(Integer tagsId, Integer userId);

    List<Tags> findAll(Integer userId);

    Optional<Tags> findByName(String name, Integer userId);
}
