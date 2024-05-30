package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.model.User;

import java.util.List;

public interface UserRepository {
    boolean createUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    List<User> getAllUsers();
}
