package com.amazon.yudoo.service;

import com.amazon.yudoo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task create(Task newTask);
    void deleteById(String taskId);
    void updateById(String taskId);
    List<Task> findAll();
    Optional<Task> findById(String taskId);
}
