package com.example.workshopapp.services;

import com.example.workshopapp.dto.devices.DeviceInfoDTO;

import java.util.List;

public interface DeviceInfoService {

    List<DeviceInfoDTO> findAllDevices();
}
