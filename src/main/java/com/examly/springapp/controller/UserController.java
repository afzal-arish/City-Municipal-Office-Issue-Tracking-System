package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<?> getByRole(@PathVariable String role) {
        List<User> users = service.getUsersByRole(role);
        if (users.isEmpty())
            return new ResponseEntity<>("No users found with role: " + role, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        User u = service.getUserByEmail(email);
        if (u == null)
            return new ResponseEntity<>("User not found with email: " + email, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/page/{page}/{size}")
    public Page<User> paginate(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(service.getAllUsers(), pageable, service.getAllUsers().size());
    }
}
