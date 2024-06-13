package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User details service.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User details service.
     *
     * @param userRepository the user repository
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("User " + username + " not found") );
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(currentUser.getRole().name()));
        return new org.springframework.security.core.userdetails.User(currentUser.getUsername(),
                currentUser.getPassword(),
                currentUser.isEnabled(),
                currentUser.isAccountNoExpired(),
                currentUser.isCredentialNoExpired(),
                currentUser.isAccountNoLocked(),
                authorities);
    }

    /**
     * Gets current user.
     *
     * @param userService the user service
     * @return the current user
     */
    public User getCurrentUser(UserService userService) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return userService.getUserByUsername(username);
        }
        return null;
    }
}
