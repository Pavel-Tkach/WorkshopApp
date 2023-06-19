package com.example.workshopapp.utils.mappers.discount;

import com.example.workshopapp.dto.discounts.DiscountInfoDTO;
import com.example.workshopapp.entities.Discount;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DiscountMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(DiscountInfoDTO.class, Discount.class);
        mapper.createTypeMap(Discount.class, DiscountInfoDTO.class);
    }

    public DiscountInfoDTO toDto(Discount entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, DiscountInfoDTO.class);
    }

    public Discount toEntity(DiscountInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, Discount.class);
    }

    public List<DiscountInfoDTO> toDiscountDtoList(List<Discount> discounts){
        List<DiscountInfoDTO> discountDTOList = discounts
                .stream()
                .map(discount -> Objects.isNull(discount) ? null : mapper.map(discount, DiscountInfoDTO.class))
                .toList();

        return discountDTOList;
    }
}
