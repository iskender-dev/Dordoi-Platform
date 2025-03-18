package com.example.DordoiPlatform.controller;

import com.example.DordoiPlatform.dto.product.ProductDetailResponse;
import com.example.DordoiPlatform.dto.product.ProductResponse;
import com.example.DordoiPlatform.entities.Product;
import com.example.DordoiPlatform.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductResponse> all(){
        return productService.all();
    }

    @GetMapping("/{id}")
    public ProductDetailResponse detail(@PathVariable Long id ){
        return productService.detail(id);
    }
}
