package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Repair_Part;

import java.util.List;

public interface RepairPartInfoRepository {

    List<Repair_Part> findAllRepairParts();

    Repair_Part findById(Long id);
}
