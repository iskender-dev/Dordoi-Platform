package com.example.DordoiPlatform.controller;

import com.example.DordoiPlatform.dto.product.ProductRequest;
import com.example.DordoiPlatform.dto.seller.SellerRequest;
import com.example.DordoiPlatform.dto.seller.SellerResponse;
import com.example.DordoiPlatform.repository.SellerRepository;
import com.example.DordoiPlatform.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seller")
public class SellerController {
    private final SellerService sellerService;

    @PostMapping("/add")
    public SellerResponse create(@RequestBody SellerRequest sellerRequest) {
        return sellerService.create(sellerRequest);
    }

    @PostMapping("/product/add")
    public void add(@RequestBody ProductRequest productRequest){
        sellerService.add(productRequest);
    }

    @PutMapping("/product/updateById/{id}")
    public void update(@RequestBody ProductRequest productRequest , @PathVariable Long id ){
        sellerService.updateById(productRequest, id);
    }

    @DeleteMapping("/product/deleteById/{productId}")
    public void deleteById(@PathVariable Long productId){
        sellerService.deleteById(productId);
    }
}
