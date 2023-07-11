package com.example.workshopapp.services;

import com.example.workshopapp.dto.service.ServiceInfoDTO;

import java.util.List;

public interface ServiceInfoService {

    List<ServiceInfoDTO> findAllServiceInfo();
}
