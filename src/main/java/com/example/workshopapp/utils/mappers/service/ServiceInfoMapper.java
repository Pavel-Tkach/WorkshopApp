package com.example.workshopapp.utils.mappers.service;

import com.example.workshopapp.dto.service.ServiceInfoDTO;
import com.example.workshopapp.entities.Service;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ServiceInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(ServiceInfoDTO.class, Service.class);
        mapper.createTypeMap(Service.class, ServiceInfoDTO.class);
    }

    public ServiceInfoDTO toDto(Service entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, ServiceInfoDTO.class);
    }

    public Service toEntity(ServiceInfoDTO dto){
        Service service =  Objects.isNull(dto) ? null : mapper.map(dto, Service.class);
        return service;
    }

    public List<ServiceInfoDTO> toServiceInfoDtoList(List<Service> services){
        List<ServiceInfoDTO> serviceInfoDTOList = services
                .stream()
                .map(service -> Objects.isNull(service) ? null : mapper.map(service, ServiceInfoDTO.class))
                .toList();

        return serviceInfoDTOList;
    }
}
