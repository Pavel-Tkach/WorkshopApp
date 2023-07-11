package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.repair_part.RepairPartInfoDTO;
import com.example.workshopapp.dto.repair_part.RepairPartWithProviderDTO;
import com.example.workshopapp.services.RepairPartInfoService;
import com.example.workshopapp.services.RepairPartWithProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repair_parts")
public class RepairPartController {

    private final RepairPartInfoService repairPartInfoService;

    private final RepairPartWithProviderService repairPartWithProviderService;

    @GetMapping("/")
    public List<RepairPartInfoDTO> findAllRepairParts(){
        return repairPartInfoService.findAllRepairParts();
    }

    @GetMapping("/{id}")
    public RepairPartInfoDTO findById(@PathVariable("id") Long id){
        return repairPartInfoService.findById(id);
    }

    @GetMapping("/{id}/repair_part_info")
    public RepairPartWithProviderDTO findByIdRepairPartWithProvider(@PathVariable("id") Long id){
        return repairPartWithProviderService.findByIdRepairPartWithProvider(id);
    }
}
