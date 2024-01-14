package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
