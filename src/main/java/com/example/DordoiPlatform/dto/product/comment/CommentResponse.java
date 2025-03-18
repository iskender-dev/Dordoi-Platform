package com.example.DordoiPlatform.dto.product.comment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponse {
    private Long id;
    private String text;
    private LocalDateTime createdAt;
    private String product;
    private String user;
}
