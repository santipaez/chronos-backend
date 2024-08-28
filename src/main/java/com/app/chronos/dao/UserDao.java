package com.app.chronos.dao;

import com.app.chronos.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void delete(Long id);

    void register(User user);
}
