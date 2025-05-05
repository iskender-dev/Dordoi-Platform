package com.example.DordoiPlatform.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String name;

    private String email;

    private String role;

    private String number;

    private String password;

}
