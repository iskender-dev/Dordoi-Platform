package com.example.DordoiPlatform.dto.product;

import com.example.DordoiPlatform.dto.product.comment.CommentResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductDetailResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt  ;
    private String description;
    private Integer views;
    private List<CommentResponse> comments;
}
