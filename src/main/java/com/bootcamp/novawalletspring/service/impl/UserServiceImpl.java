package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.Account;
import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommonsLog
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return user.get();
            }
            else {
                throw new Exception("Error getting user");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()) {
                return user.get();
            }
            else {
                throw new Exception("Error getting user");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.existsById(user.getId())) {
            try {
                return userRepository.save(user);
            } catch (Exception e) {
                log.error(e.getMessage());
                return null;
            }
        } else {
            log.error("User not found");
            return null;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterable<User> getAllUsers() {
        try {
            Iterable<User> users = userRepository.findAll();
            if (users.iterator().hasNext()) {
                return users;
            }
            else {
                throw new Exception("Error getting users");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
