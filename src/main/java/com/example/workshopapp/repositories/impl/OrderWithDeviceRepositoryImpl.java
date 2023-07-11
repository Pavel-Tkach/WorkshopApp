package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Order;
import com.example.workshopapp.repositories.OrderWithDeviceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class OrderWithDeviceRepositoryImpl implements OrderWithDeviceRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Order findByIdOrderWithDevice(Long id) {
        TypedQuery<Order> orderWithDevice = entityManager.createQuery("SELECT o FROM Order o INNER JOIN o.devices d WHERE d.id = :id", Order.class)
                .setParameter("id", id);
        return orderWithDevice.getSingleResult();
    }
}
