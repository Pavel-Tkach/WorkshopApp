package com.example.workshopapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "provider")
@Data
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String email;

    public Provider() {
    }
}
