package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Order;

public interface OrderWithDeviceRepository {

    Order findByIdOrderWithDevice(Long id);
}
