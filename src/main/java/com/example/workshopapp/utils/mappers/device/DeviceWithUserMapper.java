package com.example.workshopapp.utils.mappers.device;

import com.example.workshopapp.dto.devices.DeviceWithUserDTO;
import com.example.workshopapp.dto.users.UserInfoDTO;
import com.example.workshopapp.entities.Device;
import com.example.workshopapp.entities.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DeviceWithUserMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(DeviceWithUserDTO.class, Device.class)
                .addMappings(m -> m.skip(Device::setUser))
                .setPostConverter(toDeviceConverter());
        mapper.createTypeMap(Device.class, DeviceWithUserDTO.class)
                .addMappings(m -> m.skip(DeviceWithUserDTO::setUserInfoDTO))
                .setPostConverter(toDeviceWithUserConverter());
    }

    private Converter<DeviceWithUserDTO, Device> toDeviceConverter(){
        return context -> {
            DeviceWithUserDTO source = context.getSource();
            Device destination = context.getDestination();
            mapDeviceSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapDeviceSpecificFields(DeviceWithUserDTO source, Device destination){
        User user = toUserEntity(source.getUserInfoDTO());
        destination.setUser(user);
    }

    private User toUserEntity(UserInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    private Converter<Device, DeviceWithUserDTO> toDeviceWithUserConverter(){
        return context -> {
            Device source = context.getSource();
            DeviceWithUserDTO destination = context.getDestination();
            mapDeviceWithUserSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapDeviceWithUserSpecificFields(Device source, DeviceWithUserDTO destination){
        UserInfoDTO userInfoDTO = toUserDto(source.getUser());
        destination.setUserInfoDTO(userInfoDTO);
    }

    private UserInfoDTO toUserDto(User entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, UserInfoDTO.class);
    }

    public DeviceWithUserDTO toDto(Device entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, DeviceWithUserDTO.class);
    }

    public Device toEntity(DeviceWithUserDTO dto, User user){
        Device device =  Objects.isNull(dto) ? null : mapper.map(dto, Device.class);
        device.setUser(user);
        return device;
    }

}
