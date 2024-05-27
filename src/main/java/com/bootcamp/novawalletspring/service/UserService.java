package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.model.User;

import java.util.List;

public interface UserService {
    boolean createUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    List<User> getAllUsers();
}
