package com.example.workshopapp.services;

import com.example.workshopapp.dto.repair_part.RepairPartWithProviderDTO;

public interface RepairPartWithProviderService {

    RepairPartWithProviderDTO findByIdRepairPartWithProvider(Long id);
}
