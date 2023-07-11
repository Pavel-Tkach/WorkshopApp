package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.provider.ProviderInfoDTO;
import com.example.workshopapp.services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("/")
    public List<ProviderInfoDTO> findAllProviders(){
        return providerService.findAllProviders();
    }
}
