package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Repair_Part;
import com.example.workshopapp.repositories.RepairPartInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairPartInfoRepositoryImpl implements RepairPartInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Repair_Part> findAllRepairParts() {
        TypedQuery<Repair_Part> repair_parts = entityManager.createQuery("SELECT r FROM Repair_Part r", Repair_Part.class);
        return repair_parts.getResultList();
    }

    @Override
    public Repair_Part findById(Long id) {
        TypedQuery<Repair_Part> repair_part = entityManager.createQuery("SELECT r FROM Repair_Part r WHERE r.id = :id", Repair_Part.class)
                .setParameter("id", id);
        return repair_part.getSingleResult();
    }
}
