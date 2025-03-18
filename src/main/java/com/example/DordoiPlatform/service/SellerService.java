package com.example.DordoiPlatform.service;

import com.example.DordoiPlatform.dto.product.ProductRequest;
import com.example.DordoiPlatform.dto.seller.SellerRequest;
import com.example.DordoiPlatform.dto.seller.SellerResponse;
import com.example.DordoiPlatform.entities.Seller;

public interface SellerService {
    SellerResponse create(SellerRequest sellerRequest);
    void add(ProductRequest productRequest);

    void updateById(ProductRequest productRequest, Long id);

    void deleteById(Long productId);
}
