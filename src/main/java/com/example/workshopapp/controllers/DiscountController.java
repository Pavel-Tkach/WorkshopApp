package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.discounts.DiscountInfoDTO;
import com.example.workshopapp.services.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping("/")
    public List<DiscountInfoDTO> findAllDiscounts(){
        return discountService.findAllDiscounts();
    }
}
