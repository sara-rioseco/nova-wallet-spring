package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.User;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    User createUser(User user);

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    User getUserById(int id);

    /**
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    User getUserByUsername(String username);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User updateUser(User user);

    /**
     * Delete user.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteUser(int id);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    Iterable<User> getAllUsers();
}
