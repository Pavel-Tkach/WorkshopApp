package com.example.workshopapp.dto.users;

import com.example.workshopapp.dto.discounts.DiscountInfoDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class UserWithDiscountDTO {

    private Long id;

    private String first_name;

    private String second_name;

    private String patronymic;

    private List<DiscountInfoDTO> discountDTOList;
}
