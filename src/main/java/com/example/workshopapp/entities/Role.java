package com.example.workshopapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "role")
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(nullable = false)
    private String role_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

}
