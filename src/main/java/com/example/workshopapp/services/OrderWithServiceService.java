package com.example.workshopapp.services;

import com.example.workshopapp.dto.orders.OrderWithServiceDTO;

import java.util.List;

public interface OrderWithServiceService {

    List<OrderWithServiceDTO> findByIdOrderWithServices(Long id);
}
