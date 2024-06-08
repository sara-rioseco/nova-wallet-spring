package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    User updateUser(User user);
    boolean deleteUser(int id);
    Iterable<User> getAllUsers();
}
