package com.example.workshopapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(nullable = false)
    private String role_name;

    public Role() {
    }

    @ManyToOne
    @JoinColumn (name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


}
