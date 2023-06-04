package com.example.workshopapp.dto.repair_part;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RepairPartInfoDTO {

    private Long id;

    private String name;

    private float price;

    private int amount;
}
