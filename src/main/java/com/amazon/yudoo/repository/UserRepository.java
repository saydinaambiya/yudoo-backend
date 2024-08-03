package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.User;
import com.amazon.yudoo.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
