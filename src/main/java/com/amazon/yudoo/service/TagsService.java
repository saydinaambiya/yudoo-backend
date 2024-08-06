package com.amazon.yudoo.service;

import com.amazon.yudoo.model.Tags;
import com.amazon.yudoo.model.UserCredential;
import com.amazon.yudoo.model.request.TagsRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TagsService {
    Tags create(TagsRequest tagsRequest, String userEmail);

    void updateById(Integer tagsId, Integer userId);

    void deleteById(Integer tagsId, Integer userId);

    Page<Tags> findAll(Integer page, Integer pageSize, String sortBy, String order, Integer userId);

    Optional<Tags> findByName(String name, Integer userId);
}
