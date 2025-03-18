package com.example.DordoiPlatform.dto.user;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String number;
    private String password;
    private String email;
}
