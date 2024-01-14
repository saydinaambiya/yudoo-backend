package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<UserCredential, String> {
}
