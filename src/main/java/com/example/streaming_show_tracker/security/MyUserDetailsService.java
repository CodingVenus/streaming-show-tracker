package com.example.streaming_show_tracker.security;

import com.example.streaming_show_tracker.model.User;
import com.example.streaming_show_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetailsService {

    private UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

}
