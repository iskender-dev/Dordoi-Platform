package com.example.DordoiPlatform.dto.seller;

import com.example.DordoiPlatform.dto.product.ProductResponse;
import lombok.Data;

import java.util.List;

@Data
public class SellerResponse {
    private Long id;
    private String name;
    private String surname;
    private String container_location;
    private Integer number;
    private String whatsapp ;
    private String telegram;
    private String workingHours;
    List<ProductResponse> products;
}
