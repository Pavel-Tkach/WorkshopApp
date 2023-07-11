package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.users.UserWithDiscountDTO;
import com.example.workshopapp.repositories.UserWithDiscountsRepository;
import com.example.workshopapp.services.UserWithDiscountsService;
import com.example.workshopapp.utils.mappers.user.UserWithDiscountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserWithDiscountsServiceImpl implements UserWithDiscountsService {

    private final UserWithDiscountMapper mapper;

    private final UserWithDiscountsRepository userWithDiscountsRepository;

    @Override
    public List<UserWithDiscountDTO> findByIdUserWithDiscounts(Long id) {
        return mapper.toUserWithDiscountDtoList(userWithDiscountsRepository.findByIdUserWithDiscounts(id));
    }
}
