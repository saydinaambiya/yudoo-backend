package com.amazon.yudoo.repository;

import com.amazon.yudoo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}
