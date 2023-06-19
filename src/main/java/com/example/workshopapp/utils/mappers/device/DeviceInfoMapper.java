package com.example.workshopapp.utils.mappers.device;

import com.example.workshopapp.dto.devices.DeviceInfoDTO;
import com.example.workshopapp.entities.Device;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DeviceInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(DeviceInfoDTO.class, Device.class);
        mapper.createTypeMap(Device.class, DeviceInfoDTO.class);
    }

    public DeviceInfoDTO toDto(Device entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, DeviceInfoDTO.class);
    }

    public Device toEntity(DeviceInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Device.class);
    }

    public List<DeviceInfoDTO> toDeviceInfoDtoList(List<Device> devices){
        List<DeviceInfoDTO> deviceDtoList = devices
                .stream()
                .map(device -> Objects.isNull(device) ? null : mapper.map(device, DeviceInfoDTO.class))
                .toList();

        return deviceDtoList;
    }
}
