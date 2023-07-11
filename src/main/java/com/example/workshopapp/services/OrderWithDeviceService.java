package com.example.workshopapp.services;

import com.example.workshopapp.dto.orders.OrderWithDeviceDTO;

public interface OrderWithDeviceService {

    OrderWithDeviceDTO findByIdOrderWithDevice(Long id);
}
