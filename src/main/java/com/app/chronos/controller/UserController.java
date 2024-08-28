package com.app.chronos.controller;

import com.app.chronos.dao.UserDao;
import com.app.chronos.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable int id) {
        User user = new User();
        user.setUsername("santipaez");
        user.setEmail("santipaez@gmail.com");
        user.setPassword("pass123");
        user.setRole("admin");
        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
