package com.example.workshopapp.utils.mappers.repair_part;

import com.example.workshopapp.dto.provider.ProviderInfoDTO;
import com.example.workshopapp.dto.repair_part.RepairPartWithProviderDTO;
import com.example.workshopapp.entities.Provider;
import com.example.workshopapp.entities.Repair_Part;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RepairPartWithProviderMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(RepairPartWithProviderDTO.class, Repair_Part.class)
                .addMappings(m -> m.skip(Repair_Part::setProvider))
                .setPostConverter(toRepairPartConverter());
        mapper.createTypeMap(Repair_Part.class, RepairPartWithProviderDTO.class)
                .addMappings(m -> m.skip(RepairPartWithProviderDTO::setProviderInfoDTO))
                .setPostConverter(toRepairPartWithProviderDtoConverter());
    }

    private Converter<RepairPartWithProviderDTO, Repair_Part> toRepairPartConverter() {
        return context -> {
          RepairPartWithProviderDTO source = context.getSource();
          Repair_Part destination = context.getDestination();
          mapRepairPartSpecificFields(source, destination);
          return context.getDestination();
        };
    }

    private void mapRepairPartSpecificFields(RepairPartWithProviderDTO source, Repair_Part destination) {
        Provider provider = toProviderEntity(source.getProviderInfoDTO());
        destination.setProvider(provider);
    }

    private Converter<Repair_Part, RepairPartWithProviderDTO> toRepairPartWithProviderDtoConverter() {
        return context -> {
          Repair_Part source = context.getSource();
          RepairPartWithProviderDTO destination = context.getDestination();
          mapRepairPartWithProviderDtoSpecificFields(source, destination);
          return context.getDestination();
        };
    }

    private void mapRepairPartWithProviderDtoSpecificFields(Repair_Part source, RepairPartWithProviderDTO destination) {
        ProviderInfoDTO providerInfoDTO = toProviderDto(source.getProvider());
        destination.setProviderInfoDTO(providerInfoDTO);
    }

    private ProviderInfoDTO toProviderDto(Provider entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, ProviderInfoDTO.class);
    }

    private Provider toProviderEntity(ProviderInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Provider.class);
    }

    public RepairPartWithProviderDTO toDto(Repair_Part entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, RepairPartWithProviderDTO.class);
    }

    public Repair_Part toEntity(RepairPartWithProviderDTO dto, Provider provider){
        Repair_Part repair_part =  Objects.isNull(dto) ? null : mapper.map(dto, Repair_Part.class);
        repair_part.setProvider(provider);
        return repair_part;
    }
}
