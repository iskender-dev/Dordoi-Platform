package com.example.DordoiPlatform.controller;

import com.example.DordoiPlatform.dto.user.UserRequest;
import com.example.DordoiPlatform.dto.user.UserResponse;
import com.example.DordoiPlatform.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final MyUserService myUserService;

    @PostMapping("/add")
    public void add(@RequestBody UserRequest request) {
        myUserService.add(request);
    }

    @GetMapping("/findById/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return myUserService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UserRequest request, @PathVariable Long id) {
        myUserService.update(request, id);
    }

    @GetMapping("/findAll")
    public List<UserResponse> findAll() {
        return myUserService.findAll();
    }
}
