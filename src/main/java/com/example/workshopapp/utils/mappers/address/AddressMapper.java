package com.example.workshopapp.utils.mappers.address;

import com.example.workshopapp.dto.addresses.AddressDTO;
import com.example.workshopapp.entities.Address;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(AddressDTO.class, Address.class);
        mapper.createTypeMap(Address.class, AddressDTO.class);
    }

    public AddressDTO toDto(Address entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, AddressDTO.class);
    }

    public Address toEntity(AddressDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Address.class);
    }

    public List<AddressDTO> toAddressDtoList(List<Address> addresses){
        List<AddressDTO> addressDtoList = addresses
                .stream()
                .map(address -> Objects.isNull(address) ? null : mapper.map(address, AddressDTO.class))
                .toList();

        return addressDtoList;
    }
}
