package com.davivienda.events.service;

import com.davivienda.events.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.davivienda.events.model.User;
import com.davivienda.events.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public User create(String username, String password, String role) {
        //TODO:Validar
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole(role);
        return repo.save(user);
    }
    public List<User> read(){
        return repo.findAll();
    }

    public Optional<User> findById(Long id) {

        return repo.findById(id);
    }
    public void update(){
        //TODO:Not implemented
    }


    public void deleteById(Long id) {
        repo.deleteById(id);
    }


}
