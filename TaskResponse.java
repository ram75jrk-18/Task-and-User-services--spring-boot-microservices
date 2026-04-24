package com.example.taskservice.dto;

import com.example.taskservice.model.Task;

public class TaskResponse {
    private Task task;
    private UserDto assignedUser;

    public TaskResponse(Task task, UserDto assignedUser) {
        this.task = task;
        this.assignedUser = assignedUser;
    }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }
    public UserDto getAssignedUser() { return assignedUser; }
    public void setAssignedUser(UserDto assignedUser) { this.assignedUser = assignedUser; }
}
