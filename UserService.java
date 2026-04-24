package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1L, "John Admin", "john@example.com", "ADMIN"));
        users.add(new User(2L, "Priya User", "priya@example.com", "USER"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User createUser(User user) {
        user.setId((long) users.size() + 1);
        users.add(user);
        return user;
    }
}
