package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.orders.OrderWithDeviceDTO;
import com.example.workshopapp.repositories.OrderWithDeviceRepository;
import com.example.workshopapp.services.OrderWithDeviceService;
import com.example.workshopapp.utils.mappers.order.OrderWithDeviceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderWithDeviceServiceImpl implements OrderWithDeviceService {

    private final OrderWithDeviceRepository orderWithDeviceRepository;

    private final OrderWithDeviceMapper mapper;

    @Override
    public OrderWithDeviceDTO findByIdOrderWithDevice(Long id) {
        return mapper.toDto(orderWithDeviceRepository.findByIdOrderWithDevice(id));
    }
}
