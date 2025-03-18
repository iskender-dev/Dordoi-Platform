package com.example.DordoiPlatform.mapper.impl;

import com.example.DordoiPlatform.dto.seller.SellerRequest;
import com.example.DordoiPlatform.dto.seller.SellerResponse;
import com.example.DordoiPlatform.entities.Seller;
import com.example.DordoiPlatform.mapper.ProductMapper;
import com.example.DordoiPlatform.mapper.SellerMapper;
import org.springframework.stereotype.Component;

@Component
public class SellerMapperImpl implements SellerMapper {

    private final ProductMapper productMapper;

    public SellerMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Seller toDtoSeller(SellerRequest request) {
        Seller seller = new Seller();
        seller.setName(request.getName());
        seller.setSurname(request.getSurname());
        seller.setContainer_location(request.getContainer_location());
        seller.setNumber(request.getNumber());
        seller.setWhatsapp(request.getWhatsapp());
        seller.setTelegram(request.getTelegram());
        seller.setWorkingHours(request.getWorkingHours());
        return seller;
    }

    @Override
    public SellerResponse toDtoSellerResponse(Seller seller) {
        SellerResponse sellerResponse = new SellerResponse();
        sellerResponse.setId(seller.getId());
        sellerResponse.setName(seller.getName());
        sellerResponse.setSurname(seller.getSurname());
        sellerResponse.setContainer_location(seller.getContainer_location());
        sellerResponse.setNumber(seller.getNumber());
        sellerResponse.setWhatsapp(seller.getWhatsapp());
        sellerResponse.setTelegram(seller.getTelegram());
        sellerResponse.setWorkingHours(seller.getWorkingHours());
        if (seller.getProducts() != null) {
            sellerResponse.setProducts(productMapper.toDtoS(seller.getProducts()));
        }
        return sellerResponse;
    }
}
