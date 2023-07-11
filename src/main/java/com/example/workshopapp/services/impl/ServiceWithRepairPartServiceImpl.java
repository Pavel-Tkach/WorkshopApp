package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.service.ServiceWithRepairPartDTO;
import com.example.workshopapp.repositories.ServiceWithRepairPartRepository;
import com.example.workshopapp.services.ServiceWithRepairPartService;
import com.example.workshopapp.utils.mappers.service.ServiceWithRepairPartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceWithRepairPartServiceImpl implements ServiceWithRepairPartService {

    private final ServiceWithRepairPartMapper mapper;

    private final ServiceWithRepairPartRepository serviceWithRepairPartRepository;

    @Override
    public List<ServiceWithRepairPartDTO> findByIdServiceWithRepairParts(Long id) {
        return mapper.toServiceWithRepairPartDtoList(serviceWithRepairPartRepository.findByIdServiceWithRepairParts(id));
    }
}
