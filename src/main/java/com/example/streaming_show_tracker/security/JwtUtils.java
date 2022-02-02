package com.example.streaming_show_tracker.security;

import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    String SECRET_KEY = "TestKey";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
}
