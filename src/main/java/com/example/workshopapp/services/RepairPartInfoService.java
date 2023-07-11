package com.example.workshopapp.services;

import com.example.workshopapp.dto.repair_part.RepairPartInfoDTO;

import java.util.List;

public interface RepairPartInfoService {

    List<RepairPartInfoDTO> findAllRepairParts();

    RepairPartInfoDTO findById(Long id);
}
