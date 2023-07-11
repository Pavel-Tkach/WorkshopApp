package com.example.workshopapp.repositories;


import com.example.workshopapp.entities.Order;

import java.util.List;

public interface OrderWithServiceRepository {

    List<Order> findByIdOrderWithServices(Long id);
}
