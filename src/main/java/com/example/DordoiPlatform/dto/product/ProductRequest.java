package com.example.DordoiPlatform.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ProductRequest {
    private String name;
    private LocalDateTime createdAt  ;
    private String description;
    private Integer views ;
}
