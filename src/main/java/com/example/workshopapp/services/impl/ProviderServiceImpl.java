package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.provider.ProviderInfoDTO;
import com.example.workshopapp.repositories.ProviderRepository;
import com.example.workshopapp.services.ProviderService;
import com.example.workshopapp.utils.mappers.provider.ProviderInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderInfoMapper mapper;

    private final ProviderRepository providerRepository;

    @Override
    public List<ProviderInfoDTO> findAllProviders() {
        return mapper.toProviderInfoDtoList(providerRepository.findAllProviders());
    }
}
