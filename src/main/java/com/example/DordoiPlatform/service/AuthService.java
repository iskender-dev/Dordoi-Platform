package com.example.DordoiPlatform.service;

import com.example.DordoiPlatform.dto.auth.AuthResponse;
import com.example.DordoiPlatform.dto.auth.LoginRequest;
import com.example.DordoiPlatform.dto.auth.RegisterRequest;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);

}
