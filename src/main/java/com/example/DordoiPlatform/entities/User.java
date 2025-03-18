package com.example.DordoiPlatform.entities;

import com.example.DordoiPlatform.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;
    private String password;
    private String email ;
    @Enumerated(EnumType.STRING)
    private Role role;
}
