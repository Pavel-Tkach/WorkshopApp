package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Service;
import com.example.workshopapp.repositories.ServiceWithRepairPartRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceWithRepairPartRepositoryImpl implements ServiceWithRepairPartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Service> findByIdServiceWithRepairParts(Long id) {
        TypedQuery<Service> serviceWithRepairParts = entityManager.createQuery("SELECT s FROM Service s INNER JOIN s.repair_parts r WHERE r.id = :id", Service.class)
                .setParameter("id", id);
        return serviceWithRepairParts.getResultList();
    }
}
