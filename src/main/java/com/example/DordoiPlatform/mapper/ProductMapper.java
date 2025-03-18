package com.example.DordoiPlatform.mapper;

import com.example.DordoiPlatform.dto.product.ProductDetailResponse;
import com.example.DordoiPlatform.dto.product.ProductRequest;
import com.example.DordoiPlatform.dto.product.ProductResponse;
import com.example.DordoiPlatform.entities.Product;

import java.util.List;

public interface ProductMapper {
    ProductResponse toDto(Product product);
    List<ProductResponse>toDtoS (List<Product> products);
    ProductDetailResponse toDetailDto(Product product);
    Product toDtoProduct(Product product , ProductRequest productRequest);
}
