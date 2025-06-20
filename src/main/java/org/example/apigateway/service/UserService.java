package org.example.apigateway.service;

import org.example.apigateway.model.User;
import org.example.apigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username)      .isPresent();
    }
}
