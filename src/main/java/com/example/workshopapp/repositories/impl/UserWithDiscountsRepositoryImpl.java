package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.User;
import com.example.workshopapp.repositories.UserWithDiscountsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserWithDiscountsRepositoryImpl implements UserWithDiscountsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findByIdUserWithDiscounts(Long id) {
        TypedQuery<User> user = entityManager.createQuery("SELECT u FROM User u INNER JOIN u.discounts d WHERE d.id = :id", User.class)
                .setParameter("id", id);
        return user.getResultList();
    }
}
