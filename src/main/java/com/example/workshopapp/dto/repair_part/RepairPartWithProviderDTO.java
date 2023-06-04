package com.example.workshopapp.dto.repair_part;

import com.example.workshopapp.dto.provider.ProviderInfoDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RepairPartWithProviderDTO {

    private Long id;

    private String name;

    private float price;

    private int amount;

    private ProviderInfoDTO providerInfoDTO;
}
