package com.example.streaming_show_tracker.service;

import com.example.streaming_show_tracker.model.Request.LoginRequest;
import com.example.streaming_show_tracker.model.Response.LoginResponse;
import com.example.streaming_show_tracker.repository.UserRepository;
import com.example.streaming_show_tracker.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtils;


    //Authentication
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmailAddress());

        final String JWT = jwtUtils.generateToken(userDetails); //once it has been generated it can't be changed

        return ResponseEntity.ok(new LoginResponse(JWT));

    }


}
