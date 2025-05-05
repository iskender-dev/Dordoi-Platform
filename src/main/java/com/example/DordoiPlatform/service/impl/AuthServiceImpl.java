package com.example.DordoiPlatform.service.impl;

import com.example.DordoiPlatform.config.JwtService;
import com.example.DordoiPlatform.dto.auth.AuthResponse;
import com.example.DordoiPlatform.dto.auth.LoginRequest;
import com.example.DordoiPlatform.dto.auth.RegisterRequest;
import com.example.DordoiPlatform.entities.User;
import com.example.DordoiPlatform.enums.Role;
import com.example.DordoiPlatform.exception.CustomException;
import com.example.DordoiPlatform.repository.UserRepository;
import com.example.DordoiPlatform.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        AuthResponse response = new AuthResponse();
        response.setToken(
                jwtService.generateToken(
                        userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND))
                )
        );
        return response;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException("User with this email is already exists", HttpStatus.CONFLICT);
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setNumber(request.getNumber());
        user.setRole(Role.valueOf(request.getRole()));
        user = userRepository.save(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(
                jwtService.generateToken(user)
        );
        return authResponse;
    }
}
