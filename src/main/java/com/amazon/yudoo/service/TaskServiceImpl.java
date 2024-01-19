package com.amazon.yudoo.service;

import com.amazon.yudoo.model.Task;
import com.amazon.yudoo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task newTask) {

        return null;
    }

    @Override
    public void deleteById(String taskId) {

    }

    @Override
    public void updateById(String taskId) {

    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(String taskId) {
        return Optional.empty();
    }
}
