package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.devices.DeviceInfoDTO;
import com.example.workshopapp.dto.devices.DeviceWithUserDTO;
import com.example.workshopapp.services.DeviceInfoService;
import com.example.workshopapp.services.DeviceWithUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceInfoService deviceInfoService;

    private final DeviceWithUserService deviceWithUserService;

    @GetMapping("/")
    public List<DeviceInfoDTO> findAllDevices(){
        return deviceInfoService.findAllDevices();
    }

    @GetMapping("/{id}")
    public DeviceWithUserDTO findByIdDeviceWithUser(@PathVariable("id") Long id){
        return deviceWithUserService.findByIdDeviceWithUser(id);
    }

}
