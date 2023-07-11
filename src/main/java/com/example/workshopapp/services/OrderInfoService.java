package com.example.workshopapp.services;

import com.example.workshopapp.dto.orders.OrderInfoDTO;

import java.util.List;

public interface OrderInfoService {

    List<OrderInfoDTO> findAllOrders();

    OrderInfoDTO findById(Long id);
}
