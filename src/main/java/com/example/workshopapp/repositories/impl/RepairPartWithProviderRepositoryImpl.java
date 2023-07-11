package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Repair_Part;
import com.example.workshopapp.repositories.RepairPartWithProviderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RepairPartWithProviderRepositoryImpl implements RepairPartWithProviderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Repair_Part findByIdRepairPartWithProvider(Long id) {
        TypedQuery<Repair_Part> repair_parts = entityManager.createQuery("SELECT r FROM Repair_Part r INNER JOIN r.provider p WHERE p.id = :id", Repair_Part.class)
                .setParameter("id", id);
        return repair_parts.getSingleResult();
    }
}
