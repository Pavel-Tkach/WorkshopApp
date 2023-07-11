package com.example.workshopapp.services;

import com.example.workshopapp.dto.devices.DeviceWithUserDTO;

public interface DeviceWithUserService {

    DeviceWithUserDTO findByIdDeviceWithUser(Long id);
}
