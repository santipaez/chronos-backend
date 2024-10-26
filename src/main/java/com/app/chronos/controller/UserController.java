package com.app.chronos.controller;

import com.app.chronos.models.User;
import com.app.chronos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.register(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateUserPassword(@PathVariable Integer id, @RequestBody String newPassword) {
        User user = userService.getUser(id);
        if (user != null) {
            user.setPassword(newPassword);
            userService.register(user);
        }
    }
}