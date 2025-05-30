package com.davivienda.events.dto;



public class RegisterRequest {
    public String username;
    public String password;
    public String role;

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    
}
