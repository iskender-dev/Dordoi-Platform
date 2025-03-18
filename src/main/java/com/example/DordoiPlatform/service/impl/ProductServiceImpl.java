package com.example.DordoiPlatform.service.impl;

import com.example.DordoiPlatform.dto.product.ProductDetailResponse;
import com.example.DordoiPlatform.dto.product.ProductResponse;
import com.example.DordoiPlatform.entities.Product;
import com.example.DordoiPlatform.exception.CustomException;
import com.example.DordoiPlatform.mapper.ProductMapper;
import com.example.DordoiPlatform.repository.ProductRepository;
import com.example.DordoiPlatform.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public List<ProductResponse> all() {
        return productMapper.toDtoS(productRepository.findAll());
    }

    @Override
    public ProductDetailResponse detail(Long id) {
        Optional<Product> product =productRepository.findById(id);
        if(product.isEmpty()){
            throw new CustomException("product is not found" , HttpStatus.NOT_FOUND);
        }
        return productMapper.toDetailDto(product.get());
    }
}
