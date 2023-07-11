package com.example.workshopapp.utils.mappers.order;

import com.example.workshopapp.dto.devices.DeviceInfoDTO;
import com.example.workshopapp.dto.orders.OrderWithDeviceDTO;
import com.example.workshopapp.entities.Device;
import com.example.workshopapp.entities.Order;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class OrderWithDeviceMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(OrderWithDeviceDTO.class, Order.class)
                .addMappings(m -> m.skip(Order::setDate))
                .addMappings(m -> m.skip(Order::setDevices))
                .setPostConverter(toOrderConverter());
        mapper.createTypeMap(Order.class, OrderWithDeviceDTO.class)
                .addMappings(m -> m.skip(OrderWithDeviceDTO::setDeviceInfoDTO))
                .setPostConverter(toOrderWithDeviceConverter());
    }

    private Converter<OrderWithDeviceDTO, Order> toOrderConverter(){
        return context -> {
            OrderWithDeviceDTO source = context.getSource();
            Order destination = context.getDestination();
            mapOrderSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapOrderSpecificFields(OrderWithDeviceDTO source, Order destination){
        Device device = toDeviceEntity(source.getDeviceInfoDTO());
        destination.setDevices(device);
        destination.setDate(LocalDateTime.now());
    }

    private Converter<Order, OrderWithDeviceDTO> toOrderWithDeviceConverter() {
        return context -> {
            Order source = context.getSource();
            OrderWithDeviceDTO destination = context.getDestination();
            mapOrderWithDeviceSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapOrderWithDeviceSpecificFields(Order source, OrderWithDeviceDTO destination) {
        DeviceInfoDTO deviceInfoDTO = toDeviceDto(source.getDevices());
        destination.setDeviceInfoDTO(deviceInfoDTO);
    }

    private Device toDeviceEntity(DeviceInfoDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Device.class);
    }

    private DeviceInfoDTO toDeviceDto(Device entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, DeviceInfoDTO.class);
    }

    public OrderWithDeviceDTO toDto(Order entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, OrderWithDeviceDTO.class);
    }

    public Order toEntity(OrderWithDeviceDTO dto, Device device){
        Order order = Objects.isNull(dto) ? null : mapper.map(dto, Order.class);
        order.setDevices(device);
        return order;
    }
}
