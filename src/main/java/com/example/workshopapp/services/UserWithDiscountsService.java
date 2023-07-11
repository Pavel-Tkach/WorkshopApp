package com.example.workshopapp.services;

import com.example.workshopapp.dto.users.UserWithDiscountDTO;

import java.util.List;

public interface UserWithDiscountsService {

    List<UserWithDiscountDTO> findByIdUserWithDiscounts(Long id);
}
