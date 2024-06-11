package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
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
}
