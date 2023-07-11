package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.repair_part.RepairPartInfoDTO;
import com.example.workshopapp.repositories.RepairPartInfoRepository;
import com.example.workshopapp.services.RepairPartInfoService;
import com.example.workshopapp.utils.mappers.repair_part.RepairPartInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairPartInfoServiceImpl implements RepairPartInfoService {

    private final RepairPartInfoRepository repairPartInfoRepository;

    private final RepairPartInfoMapper mapper;

    @Override
    public List<RepairPartInfoDTO> findAllRepairParts() {
        return mapper.toRepairPartInfoDtoList(repairPartInfoRepository.findAllRepairParts());
    }

    @Override
    public RepairPartInfoDTO findById(Long id) {
        return mapper.toDto(repairPartInfoRepository.findById(id));
    }
}
