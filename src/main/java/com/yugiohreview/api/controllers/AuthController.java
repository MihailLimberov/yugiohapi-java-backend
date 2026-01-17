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

    record RegisterRequest(String username, String password) {}
    record LoginRequest(String username, String password) {}

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        User user = new User();
        user.setUsername(req.username());
        user.setPassword(passwordEncoder.encode(req.password()));
        userRepository.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        Optional<User> existing = userRepository.findByUsername(req.username());
        if(existing.isPresent() && passwordEncoder.matches(req.password(), existing.get().getPassword())){
            return "Login successful";
        }
        return "Invalid credentials";
    }

}