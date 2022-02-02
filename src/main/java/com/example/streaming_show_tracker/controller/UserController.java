package com.example.streaming_show_tracker.controller;

import com.example.streaming_show_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/auth/users/")
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;


    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


}
