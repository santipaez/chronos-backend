package com.eventz.service;

import com.eventz.model.User;
import com.eventz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Crear un nuevo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Leer un usuario por ID
    public User readUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    // Actualizar un usuario
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Eliminar un usuario
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Leer todos los usuarios
    public Iterable<User> readAllUsers() {
        return userRepository.findAll();
    }
}