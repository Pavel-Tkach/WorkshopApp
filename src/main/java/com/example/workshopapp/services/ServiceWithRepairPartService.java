package com.example.workshopapp.services;

import com.example.workshopapp.dto.service.ServiceWithRepairPartDTO;

import java.util.List;

public interface ServiceWithRepairPartService {

    List<ServiceWithRepairPartDTO> findByIdServiceWithRepairParts(Long id);
}
