package com.example.workshopapp.utils.mappers.order;

import com.example.workshopapp.dto.orders.OrderInfoDTO;
import com.example.workshopapp.entities.Order;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class OrderInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(OrderInfoDTO.class, Order.class);
        mapper.createTypeMap(Order.class, OrderInfoDTO.class);
    }

    public OrderInfoDTO toDto(Order entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, OrderInfoDTO.class);
    }

    public Order toEntity(OrderInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Order.class);
    }

    public List<OrderInfoDTO> toOrderInfoDtoList(List<Order> orders){
        List<OrderInfoDTO> orderInfoDtoList = orders
                .stream()
                .map(order -> Objects.isNull(order) ? null : mapper.map(order, OrderInfoDTO.class)).toList();
        return orderInfoDtoList;
    }

    public List<Order> toOrderList(List<OrderInfoDTO> orderInfoDtoList){
        List<Order> orders = orderInfoDtoList
                .stream()
                .map(order -> Objects.isNull(order) ? null : mapper.map(order, Order.class)).toList();
        return orders;
    }
}
