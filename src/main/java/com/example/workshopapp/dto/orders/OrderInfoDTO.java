package com.example.workshopapp.dto.orders;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderInfoDTO {

    private Long id;

    private float price;

    private LocalDateTime date;

    private String order_status;
}
