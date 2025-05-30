package com.davivienda.events.service;


import org.springframework.beans.factory.annotation.Autowired;
import com.davivienda.events.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired private JwtTokenProvider jwtProvider;
    public String createToken(String username) {
        return jwtProvider.generateToken(username);
    }
}
