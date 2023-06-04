package com.example.workshopapp.dto.orders;

import com.example.workshopapp.dto.devices.DeviceInfoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderWithDeviceDTO {

    private Long id;

    private float price;

    private LocalDateTime date;

    private String order_status;

    private DeviceInfoDTO devices;
}
