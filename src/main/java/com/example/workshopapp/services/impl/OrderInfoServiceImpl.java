package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.orders.OrderInfoDTO;
import com.example.workshopapp.repositories.OrderInfoRepository;
import com.example.workshopapp.services.OrderInfoService;
import com.example.workshopapp.utils.mappers.order.OrderInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderInfoServiceImpl implements OrderInfoService {

    private final OrderInfoRepository orderInfoRepository;

    private final OrderInfoMapper mapper;

    @Override
    public List<OrderInfoDTO> findAllOrders() {
        return mapper.toOrderInfoDtoList(orderInfoRepository.findAllOrders());
    }

    @Override
    public OrderInfoDTO findById(Long id) {
        return mapper.toDto(orderInfoRepository.findById(id));
    }
}
