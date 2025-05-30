package com.davivienda.events.dto;

import com.davivienda.events.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterResponse {
    private User user;
    private String token;

}
