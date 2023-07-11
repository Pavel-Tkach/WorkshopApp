package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.discounts.DiscountInfoDTO;
import com.example.workshopapp.repositories.DiscountRepository;
import com.example.workshopapp.services.DiscountService;
import com.example.workshopapp.utils.mappers.discount.DiscountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    private final DiscountMapper mapper;

    @Override
    public List<DiscountInfoDTO> findAllDiscounts() {
        return mapper.toDiscountDtoList(discountRepository.findAllDiscounts());
    }
}
