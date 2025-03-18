package com.example.DordoiPlatform.service;

import com.example.DordoiPlatform.dto.product.ProductDetailResponse;
import com.example.DordoiPlatform.dto.product.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> all();
    ProductDetailResponse detail(Long id);
}
