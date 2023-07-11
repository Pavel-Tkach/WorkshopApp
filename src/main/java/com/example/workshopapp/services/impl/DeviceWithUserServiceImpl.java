package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.devices.DeviceWithUserDTO;
import com.example.workshopapp.repositories.DeviceWithUserRepository;
import com.example.workshopapp.services.DeviceWithUserService;
import com.example.workshopapp.utils.mappers.device.DeviceWithUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceWithUserServiceImpl implements DeviceWithUserService {

    private final DeviceWithUserMapper mapper;

    private final DeviceWithUserRepository deviceWithUserRepository;

    @Override
    public DeviceWithUserDTO findByIdDeviceWithUser(Long id) {
        return mapper.toDto(deviceWithUserRepository.findByIdDeviceWithUser(id));
    }
}
