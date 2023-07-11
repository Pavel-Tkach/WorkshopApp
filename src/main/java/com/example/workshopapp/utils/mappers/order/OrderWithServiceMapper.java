package com.example.workshopapp.utils.mappers.order;

import com.example.workshopapp.dto.orders.OrderWithServiceDTO;
import com.example.workshopapp.dto.service.ServiceInfoDTO;
import com.example.workshopapp.entities.Order;
import com.example.workshopapp.entities.Service;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class OrderWithServiceMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(OrderWithServiceDTO.class, Order.class)
                .addMappings(m -> m.skip(Order::setServices))
                .addMappings(m -> m.skip(Order::setDate))
                .setPostConverter(toOrderConverter());
        mapper.createTypeMap(Order.class, OrderWithServiceDTO.class)
                .addMappings(m -> m.skip(OrderWithServiceDTO::setServiceInfoDTOList))
                .setPostConverter(toOrderWithServiceConverter());
    }

    private Converter<OrderWithServiceDTO, Order> toOrderConverter(){
        return context -> {
            OrderWithServiceDTO source = context.getSource();
            Order destination = context.getDestination();
            mapOrderSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapOrderSpecificFields(OrderWithServiceDTO source, Order destination){
        List<Service> services = toServiceEntity(source.getServiceInfoDTOList());
        destination.setServices(services);
        destination.setDate(LocalDateTime.now());
    }

    private Converter<Order, OrderWithServiceDTO> toOrderWithServiceConverter() {
        return context -> {
            Order source = context.getSource();
            OrderWithServiceDTO destination = context.getDestination();
            mapOrderWithServiceSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapOrderWithServiceSpecificFields(Order source, OrderWithServiceDTO destination) {
        List<ServiceInfoDTO> serviceInfoDTOList = toServiceDto(source.getServices());
        destination.setServiceInfoDTOList(serviceInfoDTOList);
    }

    private List<Service> toServiceEntity(List<ServiceInfoDTO> serviceInfoDTOList) {
        List<Service> services = serviceInfoDTOList
                .stream()
                .map(service -> Objects.isNull(service) ? null : mapper.map(service, Service.class)).toList();
        return services;
    }

    private List<ServiceInfoDTO> toServiceDto(List<Service> services) {
        List<ServiceInfoDTO> serviceInfoDTOList = services
                .stream()
                .map(service -> Objects.isNull(service) ? null : mapper.map(service, ServiceInfoDTO.class)).toList();
        return serviceInfoDTOList;
    }

    public OrderWithServiceDTO toDto(Order entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, OrderWithServiceDTO.class);
    }

    public Order toEntity(OrderWithServiceDTO dto, List<Service> services){
        Order order = Objects.isNull(dto) ? null : mapper.map(dto, Order.class);
        order.setServices(services);
        return order;
    }

    public List<OrderWithServiceDTO> toOrderWithServiceDtoList(List<Order> orders){
        List<OrderWithServiceDTO> orderWithServiceDTOList = orders
                .stream()
                .map(order -> Objects.isNull(order) ? null : mapper.map(order, OrderWithServiceDTO.class))
                .toList();

        return orderWithServiceDTOList;
    }
}
