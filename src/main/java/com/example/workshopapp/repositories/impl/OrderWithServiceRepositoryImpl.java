package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Order;
import com.example.workshopapp.repositories.OrderWithServiceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderWithServiceRepositoryImpl implements OrderWithServiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findByIdOrderWithServices(Long id) {
        TypedQuery<Order> ordersWithServices = entityManager.createQuery("SELECT o FROM Order o INNER JOIN o.services s WHERE s.id = :id", Order.class)
                .setParameter("id", id);
        return ordersWithServices.getResultList();
    }
}
