package com.davivienda.events.controller;

import com.davivienda.events.dto.AuthResponse;
import com.davivienda.events.dto.EventResponse;
import com.davivienda.events.dto.RegisterResponse;
import com.davivienda.events.model.Event;
import com.davivienda.events.model.User;
import com.davivienda.events.service.SessionService;
import com.davivienda.events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.davivienda.events.dto.RegisterRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserService userService;
    @Autowired private SessionService sessionService;
//    @PostMapping("/login")
//    public AuthResponse login(@RequestBody AuthRequest request) {
//        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username, request.password));
//        return new AuthResponse(jwtProvider.generateToken(request.username));
//    }

    @GetMapping("/hola")
    public String test (){
        return "Hola";
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        User user =userService.create(request.username,request.password,request.role);
        String token = sessionService.createToken(request.username);
        RegisterResponse registerResponse =
                RegisterResponse.builder()
                        .user(user)
                        .token(token)
                        .build();
        return ResponseEntity.ok().body(registerResponse);

    }

    @GetMapping("/show")
    public ResponseEntity<List<User>>show() {
        List<User> userList = userService.read();
        return ResponseEntity.ok().body(userList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthResponse>getEventById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        AuthResponse userResponse =
                AuthResponse.builder()
                        .user(user.orElse(null))
                        .build();
        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
