package com.example.DordoiPlatform.mapper.impl;

import com.example.DordoiPlatform.dto.product.ProductDetailResponse;
import com.example.DordoiPlatform.dto.product.ProductRequest;
import com.example.DordoiPlatform.dto.product.ProductResponse;
import com.example.DordoiPlatform.dto.product.comment.CommentResponse;
import com.example.DordoiPlatform.entities.Product;
import com.example.DordoiPlatform.mapper.CommentMapper;
import com.example.DordoiPlatform.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final CommentMapper commentMapper;

    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setCreatedAt(product.getCreatedAt());
        return productResponse;
    }

    @Override
    public List<ProductResponse> toDtoS(List<Product> products) {
        List<ProductResponse> productResponses =new ArrayList<>();
        for(Product product: products){
            productResponses.add(toDto(product));
        }
        return productResponses;
    }

    @Override
    public ProductDetailResponse toDetailDto(Product product) {
        ProductDetailResponse response = new ProductDetailResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setViews(product.getViews());
        response.setDescription(product.getDescription());
        response.setName(product.getName());
        if (product.getComments() != null) {
            response.setComments(commentMapper.toDtoCommentResponses(product.getComments()));
        }
        return response;
    }

    @Override
    public Product toDtoProduct(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setViews(productRequest.getViews());
        product.setCreatedAt(LocalDateTime.now());
        return product;
    }
}
