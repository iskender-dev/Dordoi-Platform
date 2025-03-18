package com.example.DordoiPlatform.mapper;

import com.example.DordoiPlatform.dto.seller.SellerRequest;
import com.example.DordoiPlatform.dto.seller.SellerResponse;
import com.example.DordoiPlatform.entities.Seller;

public interface SellerMapper {
    Seller toDtoSeller(SellerRequest request);
    SellerResponse toDtoSellerResponse(Seller seller);
}
