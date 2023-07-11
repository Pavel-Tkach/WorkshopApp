package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Order;

import java.util.List;

public interface OrderInfoRepository {

    List<Order> findAllOrders();

    Order findById(Long id);
}
