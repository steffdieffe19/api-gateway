package org.example.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.example.apigateway.util.JwtUtil;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    public String generateToken(UserDetails userDetails, String role) {
        return jwtUtil.generateToken(userDetails, role);
    }

}