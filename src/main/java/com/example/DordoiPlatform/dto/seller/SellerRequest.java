package com.example.DordoiPlatform.dto.seller;

import lombok.Data;

@Data
public class SellerRequest {
    private String name;
    private String surname;
    private String container_location;
    private Integer number;
    private String whatsapp ;
    private String telegram;
    private String workingHours;
}
