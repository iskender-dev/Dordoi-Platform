package com.example.DordoiPlatform.controller;

import com.example.DordoiPlatform.dto.product.comment.CommentRequest;
import com.example.DordoiPlatform.entities.Comment;
import com.example.DordoiPlatform.mapper.CommentMapper;
import com.example.DordoiPlatform.repository.CommentRepository;
import com.example.DordoiPlatform.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/add/{userId}/product/{productId}")
    public void add(@RequestBody CommentRequest commentRequest, @PathVariable Long userId, @PathVariable Long productId) {
        commentService.add(commentRequest, userId, productId);
    }
}
