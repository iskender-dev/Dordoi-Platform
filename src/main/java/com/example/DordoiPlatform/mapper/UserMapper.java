package com.example.DordoiPlatform.mapper;

import com.example.DordoiPlatform.dto.user.UserRequest;
import com.example.DordoiPlatform.dto.user.UserResponse;
import com.example.DordoiPlatform.entities.User;

import java.util.List;

public interface UserMapper {
    UserResponse toDto(User user);
    List<UserResponse> toDtoS(List<User> users);
    User toDtoUser(User user, UserRequest userRequest);
}
