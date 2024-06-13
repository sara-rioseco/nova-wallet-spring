package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * The type User rest controller.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping
    public Iterable<User> getUsers() {
        return userService.getAllUsers();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * Gets by username.
     *
     * @param username the username
     * @return the by id
     */
    @GetMapping("username/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    @PatchMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * Delete user.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}

