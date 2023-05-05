package com.example.workshopapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private float price;
    private LocalDateTime date;

    @Column(nullable = false)
    private String order_status;

    public Order() {
    }

    @ManyToOne
    @JoinColumn(name = "device_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Device devices;

    @ManyToMany(mappedBy = "orders")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Service> services;

    @PrePersist
    protected void onCreate(){
        this.date = LocalDateTime.now();
    }
}
