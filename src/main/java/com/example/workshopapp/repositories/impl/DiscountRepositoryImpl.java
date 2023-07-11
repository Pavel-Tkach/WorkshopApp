package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Discount;
import com.example.workshopapp.repositories.DiscountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscountRepositoryImpl implements DiscountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Discount> findAllDiscounts() {
        TypedQuery<Discount> discounts = entityManager.createQuery("SELECT d FROM Discount d", Discount.class);
        return discounts.getResultList();
    }
}
