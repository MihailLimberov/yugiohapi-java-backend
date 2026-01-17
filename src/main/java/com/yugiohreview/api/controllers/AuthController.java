package com.yugiohreview.api.controllers;

import com.yugiohreview.api.models.User;
import com.yugiohreview.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> existing = userRepository.findByUsername(user.getUsername());
        if(existing.isPresent() && passwordEncoder.matches(user.getPassword(), existing.get().getPassword())){
            return "Login successful";
        }
        return "Invalid credentials";
    }
}

