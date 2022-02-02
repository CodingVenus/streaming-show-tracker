package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.repository.UserRepository;
import com.example.streaming_show_tracker.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private JWTUtils jwtUtils;
}
