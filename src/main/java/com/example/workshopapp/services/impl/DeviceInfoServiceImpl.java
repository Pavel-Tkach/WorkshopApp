package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.devices.DeviceInfoDTO;
import com.example.workshopapp.repositories.DeviceInfoRepository;
import com.example.workshopapp.services.DeviceInfoService;
import com.example.workshopapp.utils.mappers.device.DeviceInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceInfoServiceImpl implements DeviceInfoService {

    private final DeviceInfoMapper mapper;

    private final DeviceInfoRepository deviceInfoRepository;

    @Override
    public List<DeviceInfoDTO> findAllDevices() {
        return mapper.toDeviceInfoDtoList(deviceInfoRepository.findAllDevices());
    }
}
