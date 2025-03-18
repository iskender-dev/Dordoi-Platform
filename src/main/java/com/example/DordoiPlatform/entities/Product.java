package com.example.DordoiPlatform.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private LocalDateTime createdAt  ;
    private Integer views ;
    @OneToMany
    private List<Comment> comments;
    @ManyToOne
    private Seller seller ;
}
