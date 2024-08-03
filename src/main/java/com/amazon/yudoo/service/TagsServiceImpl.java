package com.amazon.yudoo.service;

import com.amazon.yudoo.exception.NotFoundException;
import com.amazon.yudoo.model.Tags;
import com.amazon.yudoo.model.User;
import com.amazon.yudoo.model.UserCredential;
import com.amazon.yudoo.model.request.TagsRequest;
import com.amazon.yudoo.repository.TagsRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagsServiceImpl implements TagsService{
    private final TagsRepository tagsRepository;
    private final UserService userService;

    public TagsServiceImpl(TagsRepository tagsRepository, UserService userService) {
        this.tagsRepository = tagsRepository;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Tags create(TagsRequest tagsRequest, String userEmail) {
        try{
            Optional<User> userLoggedIn = userService.findByEmail(userEmail);
            if (userLoggedIn.isEmpty()) throw new NotFoundException();
            Tags newTags = new Tags();
            newTags.setTagName(tagsRequest.getTagName());
            newTags.setCreatedBy(userLoggedIn.get());
            return tagsRepository.save(newTags);
        }catch (DataIntegrityViolationException e){
            throw new EntityExistsException();
        }
    }

    @Override
    public void updateById(Integer tagsId, Integer userId) {

    }

    @Override
    public void deleteById(Integer tagsId, Integer userId) {

    }

    @Override
    public Page<Tags> findAll(Integer page, Integer pageSize, String sortBy, String order, Integer userId) {
        return null;
    }

    @Override
    public Optional<Tags> findByName(String name, Integer userId) {
        return Optional.empty();
    }
}
