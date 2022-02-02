package com.example.streaming_show_tracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;

@EnableWebSecurity
public class SecurityConfigurer {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfigurer(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }


}
