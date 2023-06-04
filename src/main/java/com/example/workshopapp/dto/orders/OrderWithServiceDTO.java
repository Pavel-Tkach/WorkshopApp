package com.example.workshopapp.dto.orders;

import com.example.workshopapp.dto.service.ServiceInfoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderWithServiceDTO {

    private Long id;

    private float price;

    private LocalDateTime date;

    private String order_status;

    private List<ServiceInfoDTO> services;
}
