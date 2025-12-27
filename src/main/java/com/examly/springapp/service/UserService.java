package com.examly.springapp.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private int idCounter = 1;

    public User addUser(User user) {
        user.setUserId(idCounter++);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(u -> u.getUserId() == id).findFirst().orElse(null);
    }

    public User updateUser(int id, User updated) {
        User user = getUserById(id);
        if (user != null) {
            user.setUsername(updated.getUsername());
            user.setEmail(updated.getEmail());
            user.setFullName(updated.getFullName());
            user.setRole(updated.getRole());
        }
        return user;
    }

    public List<User> getUsersByRole(String role) {
        List<User> list = new ArrayList<>();
        for (User u : users) {
            if (u.getRole().equalsIgnoreCase(role)) list.add(u);
        }
        return list;
    }

    public User getUserByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
