package com.example.workshopapp.utils.mappers.user;

import com.example.workshopapp.dto.addresses.AddressDTO;
import com.example.workshopapp.dto.users.UserWithAddressDTO;
import com.example.workshopapp.entities.Address;
import com.example.workshopapp.entities.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserWithAddressMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(UserWithAddressDTO.class, User.class)
                .addMappings(m -> m.skip(User::setAddress))
                .setPostConverter(toUserConverter());
        mapper.createTypeMap(User.class, UserWithAddressDTO.class)
                .addMappings(m -> m.skip(UserWithAddressDTO::setAddressDTO))
                .setPostConverter(toUserWithAddressConverter());

    }

    private Converter<UserWithAddressDTO, User> toUserConverter() {
        return context -> {
            UserWithAddressDTO source = context.getSource();
            User destination = context.getDestination();
            mapUserSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapUserSpecificFields(UserWithAddressDTO source, User destination) {
        Address address = toAddressEntity(source.getAddressDTO());
        destination.setAddress(address);
    }

    private Converter<User, UserWithAddressDTO> toUserWithAddressConverter() {
        return context -> {
            User source = context.getSource();
            UserWithAddressDTO destination = context.getDestination();
            mapUserWithAddressSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapUserWithAddressSpecificFields(User source, UserWithAddressDTO destination) {
        AddressDTO addressDTO = toAddressDto(source.getAddress());
        destination.setAddressDTO(addressDTO);
    }

    private Address toAddressEntity(AddressDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Address.class);
    }

    private AddressDTO toAddressDto(Address entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, AddressDTO.class);
    }

    public UserWithAddressDTO toDto(User entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, UserWithAddressDTO.class);
    }

    public User toEntity(UserWithAddressDTO dto, Address address){
        User user =  Objects.isNull(dto) ? null : mapper.map(dto, User.class);
        user.setAddress(address);
        return user;
    }

}
