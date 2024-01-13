package com.amazon.yudoo.service;

import com.amazon.yudoo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User newUser);
    void deleteById(String userId);
    void updateById(User existedUser);
    List<User> findAll();
    Optional<User> findById(String userId);
}
