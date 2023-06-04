package com.example.workshopapp.dto.devices;

import com.example.workshopapp.dto.users.UserInfoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceWithUserDTO {

    private Long id;

    private String imei;

    private String model_name;

    private String device_manufacturer;

    private UserInfoDTO userInfoDTO;
}
