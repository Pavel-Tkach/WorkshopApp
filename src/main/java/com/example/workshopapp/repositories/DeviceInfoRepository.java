package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Device;

import java.util.List;

public interface DeviceInfoRepository {

    List<Device> findAllDevices();
}
