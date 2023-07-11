package com.example.workshopapp.services;

import com.example.workshopapp.dto.discounts.DiscountInfoDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountInfoDTO> findAllDiscounts();
}
