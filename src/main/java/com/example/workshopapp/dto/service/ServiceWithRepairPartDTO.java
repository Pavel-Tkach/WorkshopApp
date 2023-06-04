package com.example.workshopapp.dto.service;

import com.example.workshopapp.dto.repair_part.RepairPartWithProviderDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ServiceWithRepairPartDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime waiting_time;

    private float price;

    private List<RepairPartWithProviderDTO> repairPartInfoDTOList;
}
