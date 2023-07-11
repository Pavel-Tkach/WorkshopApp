package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.orders.OrderWithServiceDTO;
import com.example.workshopapp.repositories.OrderWithServiceRepository;
import com.example.workshopapp.services.OrderWithServiceService;
import com.example.workshopapp.utils.mappers.order.OrderWithServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderWithServiceServiceImpl implements OrderWithServiceService {

    private final OrderWithServiceMapper mapper;

    private final OrderWithServiceRepository orderWithServiceRepository;

    @Override
    public List<OrderWithServiceDTO> findByIdOrderWithServices(Long id) {
        return mapper.toOrderWithServiceDtoList(orderWithServiceRepository.findByIdOrderWithServices(id));
    }
}
