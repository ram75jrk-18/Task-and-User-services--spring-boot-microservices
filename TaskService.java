package com.example.taskservice.service;

import com.example.taskservice.dto.TaskResponse;
import com.example.taskservice.dto.UserDto;
import com.example.taskservice.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    public TaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        tasks.add(new Task(1L, "Create Login API", "Develop login endpoint", "IN_PROGRESS", 1L));
        tasks.add(new Task(2L, "Build Dashboard", "Create task dashboard UI", "PENDING", 2L));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> getTaskById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public Task createTask(Task task) {
        task.setId((long) tasks.size() + 1);
        tasks.add(task);
        return task;
    }

    public Optional<TaskResponse> getTaskWithAssignedUser(Long taskId) {
        return getTaskById(taskId).map(task -> {
            UserDto user = restTemplate.getForObject(userServiceUrl + "/" + task.getAssignedUserId(), UserDto.class);
            return new TaskResponse(task, user);
        });
    }
}
