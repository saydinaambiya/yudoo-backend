package com.amazon.yudoo.service;

import com.amazon.yudoo.model.User;
import com.amazon.yudoo.model.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User newUser);
    void deleteById(Integer userId);
    void updateById(User existedUser);
    List<User> findAll();
    Optional<User> findById(Integer userId);
    Optional<User> findByEmail(String email);
}
