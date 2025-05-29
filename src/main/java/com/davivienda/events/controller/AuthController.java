package com.davivienda.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davivienda.events.dto.AuthRequest;
import com.davivienda.events.dto.AuthResponse;
import com.davivienda.events.dto.RegisterRequest;
import com.davivienda.events.model.User;
import com.davivienda.events.repository.UserRepository;
import com.davivienda.events.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtTokenProvider jwtProvider;
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder encoder;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username, request.password));
        return new AuthResponse(jwtProvider.generateToken(request.username));
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username);
        user.setPassword(encoder.encode(request.password));
        user.setRole(request.role);
        userRepo.save(user);
        return "Usuario registrado";
    }
}
