package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.repair_part.RepairPartWithProviderDTO;
import com.example.workshopapp.repositories.RepairPartWithProviderRepository;
import com.example.workshopapp.services.RepairPartWithProviderService;
import com.example.workshopapp.utils.mappers.repair_part.RepairPartWithProviderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepairPartWithProviderServiceImpl implements RepairPartWithProviderService {

    private final RepairPartWithProviderRepository repairPartWithProviderRepository;

    private final RepairPartWithProviderMapper mapper;

    @Override
    public RepairPartWithProviderDTO findByIdRepairPartWithProvider(Long id) {
        return mapper.toDto(repairPartWithProviderRepository.findByIdRepairPartWithProvider(id));
    }
}
