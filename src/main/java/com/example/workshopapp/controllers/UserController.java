package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.users.UserInfoDTO;
import com.example.workshopapp.dto.users.UserWithAddressDTO;
import com.example.workshopapp.dto.users.UserWithDiscountDTO;
import com.example.workshopapp.services.UserInfoService;
import com.example.workshopapp.services.UserWithAddressService;
import com.example.workshopapp.services.UserWithDiscountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserInfoService userInfoService;

    private final UserWithAddressService userWithAddressService;

    private final UserWithDiscountsService userWithDiscountsService;

    @GetMapping("/{id}")
    public UserInfoDTO findById(@PathVariable("id") Long id){
        return userInfoService.findById(id);
    }

    @GetMapping("/{id}/profile")
    public UserWithAddressDTO findByIdUserWithAddress(@PathVariable("id") Long id){
        return userWithAddressService.findByIdUserWithAddress(id);
    }

    @GetMapping("/{id}/profile/discounts")
    public List<UserWithDiscountDTO> findByIdUserWithDiscounts(@PathVariable("id") Long id){
        return userWithDiscountsService.findByIdUserWithDiscounts(id);
    }
}
