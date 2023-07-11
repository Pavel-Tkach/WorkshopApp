package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.service.ServiceInfoDTO;
import com.example.workshopapp.repositories.ServiceInfoRepository;
import com.example.workshopapp.services.ServiceInfoService;
import com.example.workshopapp.utils.mappers.service.ServiceInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceInfoServiceImpl implements ServiceInfoService {

    private final ServiceInfoRepository serviceInfoRepository;

    private final ServiceInfoMapper serviceInfoMapper;

    @Override
    public List<ServiceInfoDTO> findAllServiceInfo() {
        return serviceInfoMapper.toServiceInfoDtoList(serviceInfoRepository.findAll());
    }


}
