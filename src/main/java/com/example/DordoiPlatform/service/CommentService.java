package com.example.DordoiPlatform.service;

import com.example.DordoiPlatform.dto.product.comment.CommentRequest;

public interface CommentService {
    void add(CommentRequest commentRequest, Long userId, Long productId);
}
