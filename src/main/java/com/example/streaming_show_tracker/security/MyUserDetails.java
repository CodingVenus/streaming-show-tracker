package com.example.streaming_show_tracker.security;

import com.example.streaming_show_tracker.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class MyUserDetails implements UserDetails {

    //FIELDS
    private User user;
    private String userName;
    private String password;
    private String emailAddress;


    //CONSTRUCTOR
    public MyUserDetails(User user) {
        this.user = user;
    }


    //OVERRIDED METHODS
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername(){
        return user.getEmailAddress();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    //GET USER METHOD
    public User getUser() {
        return user;
    }

}
