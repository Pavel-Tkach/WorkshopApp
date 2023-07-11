package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Order;
import com.example.workshopapp.repositories.OrderInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderInfoRepositoryImpl implements OrderInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAllOrders() {
        TypedQuery<Order> orders = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return orders.getResultList();
    }

    @Override
    public Order findById(Long id) {
        TypedQuery<Order> order = entityManager.createQuery("SELECT o FROM Order o WHERE o.id = :id", Order.class).setParameter("id", id);
        return order.getSingleResult();
    }


}
