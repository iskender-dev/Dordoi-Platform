package com.example.DordoiPlatform.dto.user;

import com.example.DordoiPlatform.enums.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String number;
    private String password;
    private String email ;
    private String role;
}
