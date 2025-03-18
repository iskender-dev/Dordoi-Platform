package com.example.DordoiPlatform.mapper.impl;

import com.example.DordoiPlatform.dto.user.UserRequest;
import com.example.DordoiPlatform.dto.user.UserResponse;
import com.example.DordoiPlatform.entities.User;
import com.example.DordoiPlatform.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse toDto(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setNumber(user.getNumber());
        response.setEmail(user.getEmail());
        response.setRole(String.valueOf(user.getRole()));
        return response;
    }

    @Override
    public List<UserResponse> toDtoS(List<User> users) {
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(toDto(user));
        }
        return responses;
    }

    @Override
    public User toDtoUser(User user, UserRequest userRequest) {
        user.setName(userRequest.getName());
        user.setNumber(userRequest.getNumber());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return user;
    }
}
