package com.app.controllers.auth;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
