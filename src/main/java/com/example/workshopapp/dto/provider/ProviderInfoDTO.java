package com.example.workshopapp.dto.provider;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProviderInfoDTO {

    private Long id;

    private String name;

    private String phone_number;

    private String email;
}
