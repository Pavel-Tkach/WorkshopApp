package com.example.workshopapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;

@Entity
@Table(name = "repair_part")
@Data
public class Repair_Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_part_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int amount;

    public Repair_Part() {
    }

    @ManyToOne
    @JoinColumn(name = "provider_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Provider provider;

    @ManyToMany(mappedBy = "repair_parts")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Service> services;
}
