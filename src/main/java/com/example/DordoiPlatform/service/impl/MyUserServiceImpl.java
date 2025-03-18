package com.example.DordoiPlatform.service.impl;

import com.example.DordoiPlatform.dto.user.UserRequest;
import com.example.DordoiPlatform.dto.user.UserResponse;
import com.example.DordoiPlatform.entities.User;
import com.example.DordoiPlatform.exception.CustomException;
import com.example.DordoiPlatform.mapper.UserMapper;
import com.example.DordoiPlatform.repository.UserRepository;
import com.example.DordoiPlatform.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void add(UserRequest request) {
        User user = new User();
        user = userMapper.toDtoUser(user, request);
        userRepository.save(user);
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        return userMapper.toDto(user.get());
    }

    @Override
    public void update(UserRequest request, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        user = Optional.ofNullable(userMapper.toDtoUser(user.get(), request));
        userRepository.save(user.get());
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoS(users);
    }
}
