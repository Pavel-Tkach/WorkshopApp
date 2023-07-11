package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.orders.OrderInfoDTO;
import com.example.workshopapp.dto.orders.OrderWithDeviceDTO;
import com.example.workshopapp.dto.orders.OrderWithServiceDTO;
import com.example.workshopapp.services.OrderInfoService;
import com.example.workshopapp.services.OrderWithDeviceService;
import com.example.workshopapp.services.OrderWithServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderInfoService orderInfoService;

    private final OrderWithDeviceService orderWithDeviceService;

    private final OrderWithServiceService orderWithServiceService;

    @GetMapping("/")
    public List<OrderInfoDTO> findAllOrders(){
        return orderInfoService.findAllOrders();
    }

    @GetMapping("/{id}")
    public OrderInfoDTO findById(@PathVariable("id") Long id){
        return orderInfoService.findById(id);
    }

    @GetMapping("/{id}/info")
    public OrderWithDeviceDTO findByIdOrderWithDevice(@PathVariable("id") Long id){
        return orderWithDeviceService.findByIdOrderWithDevice(id);
    }

    @GetMapping("/{id}/info/service")
    public List<OrderWithServiceDTO> findByIdOrderWithServices(@PathVariable("id") Long id){
        return orderWithServiceService.findByIdOrderWithServices(id);
    }
}
