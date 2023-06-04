package com.example.workshopapp.dto.discounts;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiscountInfoDTO {

    private Long id;

    private String description;

    private String discount_type;

    private float discount_amount;

}
