package com.example.DordoiPlatform.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String container_location;
    private Integer number;
    private String whatsapp ;
    private String telegram;
    private String workingHours;
    @OneToMany
    List<Product> products;
}
