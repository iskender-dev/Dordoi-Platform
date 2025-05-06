package com.example.DordoiPlatform.controller;

import com.example.DordoiPlatform.dto.auth.AuthResponse;
import com.example.DordoiPlatform.dto.auth.LoginRequest;
import com.example.DordoiPlatform.dto.auth.RegisterRequest;
import com.example.DordoiPlatform.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
