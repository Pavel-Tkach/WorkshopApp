package com.example.workshopapp.services;

import com.example.workshopapp.dto.provider.ProviderInfoDTO;

import java.util.List;

public interface ProviderService {

    List<ProviderInfoDTO> findAllProviders();
}
