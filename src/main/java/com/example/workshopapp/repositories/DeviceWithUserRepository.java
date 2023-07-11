package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Device;

public interface DeviceWithUserRepository {

    Device findByIdDeviceWithUser(Long id);
}
