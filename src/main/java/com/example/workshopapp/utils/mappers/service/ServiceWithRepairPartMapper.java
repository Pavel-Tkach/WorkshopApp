package com.example.workshopapp.utils.mappers.service;

import com.example.workshopapp.dto.repair_part.RepairPartInfoDTO;
import com.example.workshopapp.dto.service.ServiceWithRepairPartDTO;
import com.example.workshopapp.entities.Repair_Part;
import com.example.workshopapp.entities.Service;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ServiceWithRepairPartMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(ServiceWithRepairPartDTO.class, Service.class)
                .addMappings(m -> m.skip(Service::setRepair_parts))
                .setPostConverter(toServiceConverter());
        mapper.createTypeMap(Service.class, ServiceWithRepairPartDTO.class)
                .addMappings(m -> m.skip(ServiceWithRepairPartDTO::setRepairPartInfoDTOList))
                .setPostConverter(toServiceWithRepairPartConverter());
    }

    private Converter<ServiceWithRepairPartDTO, Service> toServiceConverter() {
        return context -> {
            ServiceWithRepairPartDTO source = context.getSource();
            Service destination = context.getDestination();
            mapServiceSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapServiceSpecificFields(ServiceWithRepairPartDTO source, Service destination) {
        List<Repair_Part> repair_part = toRepairPartEntity(source.getRepairPartInfoDTOList());
        destination.setRepair_parts(repair_part);
    }

    private Converter<Service, ServiceWithRepairPartDTO> toServiceWithRepairPartConverter() {
        return context -> {
          Service source = context.getSource();
          ServiceWithRepairPartDTO destination = context.getDestination();
          mapServiceWithRepairPartSpecificFields(source, destination);
          return context.getDestination();
        };
    }

    private void mapServiceWithRepairPartSpecificFields(Service source, ServiceWithRepairPartDTO destination) {
        List<RepairPartInfoDTO> repairPartInfoDTOList = toRepairPartDto(source.getRepair_parts());
        destination.setRepairPartInfoDTOList(repairPartInfoDTOList);
    }

    private List<Repair_Part> toRepairPartEntity(List<RepairPartInfoDTO> repairPartInfoDTOList) {
        List<Repair_Part> repairPartsList = repairPartInfoDTOList
                .stream()
                .map(repair_part -> Objects.isNull(repair_part) ? null : mapper.map(repair_part, Repair_Part.class))
                .toList();

        return repairPartsList;
    }

    private List<RepairPartInfoDTO> toRepairPartDto(List<Repair_Part> repair_parts) {
        List<RepairPartInfoDTO> repairPartInfoDTOList = repair_parts
                .stream()
                .map(repair_part -> Objects.isNull(repair_part) ? null : mapper.map(repair_part, RepairPartInfoDTO.class))
                .toList();

        return repairPartInfoDTOList;
    }

    public ServiceWithRepairPartDTO toDto(Service entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, ServiceWithRepairPartDTO.class);
    }

    public Service toEntity(ServiceWithRepairPartDTO dto, List<Repair_Part> repair_part){
        Service service =  Objects.isNull(dto) ? null : mapper.map(dto, Service.class);
        service.setRepair_parts(repair_part);
        return service;
    }

    public List<ServiceWithRepairPartDTO> toServiceWithRepairPartDtoList(List<Service> services){
        List<ServiceWithRepairPartDTO> serviceWithRepairPartDTOList = services
                .stream()
                .map(service -> Objects.isNull(service) ? null : mapper.map(service, ServiceWithRepairPartDTO.class))
                .toList();

        return serviceWithRepairPartDTOList;
    }
}
