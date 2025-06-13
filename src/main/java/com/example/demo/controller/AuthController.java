package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.user.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/singup")
    public ResponseEntity<?> singup(@RequestBody Users users) {
        if (userRepository.existsByUsername(users.getUsername())) {
            return ResponseEntity.badRequest().body("Username già esistente");
        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);

        return ResponseEntity.status(HttpStatus.CREATED).body("Utente creato con successo");
    }
}
