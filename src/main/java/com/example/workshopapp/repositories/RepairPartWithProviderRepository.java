package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Repair_Part;

public interface RepairPartWithProviderRepository {

    Repair_Part findByIdRepairPartWithProvider(Long id);
}
