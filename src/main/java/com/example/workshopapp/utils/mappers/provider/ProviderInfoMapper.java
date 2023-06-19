package com.example.workshopapp.utils.mappers.provider;

import com.example.workshopapp.dto.provider.ProviderInfoDTO;
import com.example.workshopapp.entities.Provider;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProviderInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(ProviderInfoDTO.class, Provider.class);
        mapper.createTypeMap(Provider.class, ProviderInfoDTO.class);
    }

    public ProviderInfoDTO toDto(Provider entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, ProviderInfoDTO.class);
    }

    public Provider toEntity(ProviderInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Provider.class);
    }

    public List<ProviderInfoDTO> toProviderInfoDtoList(List<Provider> providers){
        List<ProviderInfoDTO> providerInfoDtoList = providers
                .stream()
                .map(provider -> Objects.isNull(provider) ? null : mapper.map(provider, ProviderInfoDTO.class))
                .toList();

        return providerInfoDtoList;
    }
}
