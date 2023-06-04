package com.example.workshopapp.dto.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceInfoDTO {

    private Long id;

    private String imei;

    private String model_name;

    private String device_manufacturer;
}
