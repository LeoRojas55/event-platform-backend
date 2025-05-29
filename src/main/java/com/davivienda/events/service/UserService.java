package com.davivienda.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.davivienda.events.model.User;
import com.davivienda.events.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public User save(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole(role);
        return repo.save(user);
    }
}
