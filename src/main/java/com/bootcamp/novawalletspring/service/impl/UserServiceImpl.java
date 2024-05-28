package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.UserEntity;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.model.User;
import com.bootcamp.novawalletspring.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommonsLog
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean createUser(User user) {
        if (user != null
                && user.getFirstName() !=null
                && !user.getFirstName().isBlank()
                && user.getLastName() !=null
                && !user.getLastName().isBlank()
                && user.getEmail() !=null
                && !user.getEmail().isBlank()
                && user.getPassword() !=null
                && !user.getPassword().isBlank()
                && userRepository.getByEmail(user.getEmail()) == null) {
            return userRepository.save(user) > 0;
        } else {
            System.out.println("Error creating user");
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        return new User(userRepository.getById(id));
    }

    @Override
    public User getUserByEmail(String email) {
        return new User(userRepository.getByEmail(email));
    }

    @Override
    public boolean updateUser(User user) {
        if (user != null
                && user.getFirstName() != null
                && !user.getFirstName().isBlank()
                && user.getLastName() != null
                && !user.getLastName().isBlank()
                && user.getPassword() != null
                && !user.getPassword().isBlank()
                && userRepository.getById(user.getId()) != null) {
            return userRepository.update(user, user.getId()) > 0;
        } else {
            System.out.println("Error updating user");
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        if (userRepository.getById(id) != null) {
            return userRepository.delete(id) > 0;
        } else {
            System.out.println("Error deleting user");
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> users = userRepository.getAll();
        List<User> result = new ArrayList<>();
        for (UserEntity user : users) {
            result.add(new User(user));
        }
        return result;
    }
}
