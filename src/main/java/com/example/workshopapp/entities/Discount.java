package com.example.workshopapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;


@Entity
@Table(name = "discount")
@Data
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String discount_type;

    @Column(nullable = false)
    private float discount_amount;

    public Discount() {
    }

    @ManyToMany(mappedBy = "discounts")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<User> users;


}
