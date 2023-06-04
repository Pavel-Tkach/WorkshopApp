package com.example.workshopapp.dto.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ServiceInfoDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime waiting_time;

    private float price;
}
