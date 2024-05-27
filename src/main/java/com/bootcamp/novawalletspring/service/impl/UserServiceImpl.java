package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.model.User;
import com.bootcamp.novawalletspring.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommonsLog
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
                && userRepository.getUserByEmail(user.getEmail()) == null) {
            return userRepository.addUser(user);
        } else {
            System.out.println("Error creating user");
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public boolean updateUser(User user) {
        if (user != null
                && user.getFirstName() !=null
                && !user.getFirstName().isBlank()
                && user.getLastName() !=null
                && !user.getLastName().isBlank()
                && user.getPassword() !=null
                && !user.getPassword().isBlank()
                && userRepository.getUserById(user.getId()) != null) {
            return userRepository.updateUser(user);
        } else {
            System.out.println("Error updating user");
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        if (userRepository.getUserById(id) != null) {
            return userRepository.deleteUser(id);
        } else {
            System.out.println("Error deleting user");
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
