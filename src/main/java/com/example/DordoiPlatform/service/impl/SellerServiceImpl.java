package com.example.DordoiPlatform.service.impl;

import com.example.DordoiPlatform.dto.product.ProductRequest;
import com.example.DordoiPlatform.dto.seller.SellerRequest;
import com.example.DordoiPlatform.dto.seller.SellerResponse;
import com.example.DordoiPlatform.entities.Product;
import com.example.DordoiPlatform.entities.Seller;
import com.example.DordoiPlatform.exception.CustomException;
import com.example.DordoiPlatform.mapper.ProductMapper;
import com.example.DordoiPlatform.mapper.SellerMapper;
import com.example.DordoiPlatform.repository.ProductRepository;
import com.example.DordoiPlatform.repository.SellerRepository;
import com.example.DordoiPlatform.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final ProductRepository productRepository ;
    private final ProductMapper productMapper;
    private final SellerMapper sellerMapper;
    private final SellerRepository sellerRepository;

    @Override
    public SellerResponse create(SellerRequest sellerRequest) {
        Seller seller = sellerMapper.toDtoSeller(sellerRequest);
        seller = sellerRepository.save(seller);

        return sellerMapper.toDtoSellerResponse(seller);
    }

    @Override
    public void add(ProductRequest productRequest) {
        Product product =new Product();
        productRepository.save(productMapper.toDtoProduct(product, productRequest));
    }

    @Override
    public void updateById(ProductRequest productRequest, Long id) {
        Optional<Product>product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new CustomException("product not found" , HttpStatus.NOT_FOUND);
        }
        productRepository.save(productMapper.toDtoProduct(product.get() , productRequest));
    }

    @Override
    public void deleteById(Long productId) {
        Optional<Product>product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new CustomException("product not found" , HttpStatus.NOT_FOUND);
        }
        productRepository.deleteById(productId);
    }
}
