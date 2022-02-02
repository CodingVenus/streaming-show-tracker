package com.example.streaming_show_tracker.security;

import com.example.streaming_show_tracker.model.User;
import com.example.streaming_show_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService {

    private UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    public UserDetails loadUserByUsername(String email){
        User user = userService.findUserByEmailAddress(email);
        return new MyUserDetails(user);
    }
}
