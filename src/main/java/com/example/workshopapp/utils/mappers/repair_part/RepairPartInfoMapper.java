package com.example.workshopapp.utils.mappers.repair_part;

import com.example.workshopapp.dto.repair_part.RepairPartInfoDTO;
import com.example.workshopapp.dto.repair_part.RepairPartWithProviderDTO;
import com.example.workshopapp.entities.Provider;
import com.example.workshopapp.entities.Repair_Part;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RepairPartInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(RepairPartInfoDTO.class, Repair_Part.class);
        mapper.createTypeMap(Repair_Part.class, RepairPartInfoDTO.class);
    }

    public RepairPartInfoDTO toDto(Repair_Part entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, RepairPartInfoDTO.class);
    }

    public Repair_Part toEntity(RepairPartInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Repair_Part.class);
    }

    public List<RepairPartInfoDTO> toRepairPartInfoDtoList(List<Repair_Part> repair_parts){
        List<RepairPartInfoDTO> repairPartInfoDtoList = repair_parts
                .stream()
                .map(repair_part -> Objects.isNull(repair_part) ? null : mapper.map(Repair_Part.class, RepairPartInfoDTO.class))
                .toList();
        return repairPartInfoDtoList;
    }

}
