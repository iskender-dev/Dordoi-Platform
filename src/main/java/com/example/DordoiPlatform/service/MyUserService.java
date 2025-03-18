package com.example.DordoiPlatform.service;

import com.example.DordoiPlatform.dto.user.UserRequest;
import com.example.DordoiPlatform.dto.user.UserResponse;

import java.util.List;

public interface MyUserService {
    void add(UserRequest request);
    UserResponse findById(Long id);
    void update(UserRequest request, Long id);
    List<UserResponse> findAll();
}
