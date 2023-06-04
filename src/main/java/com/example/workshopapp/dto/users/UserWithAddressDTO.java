package com.example.workshopapp.dto.users;

import com.example.workshopapp.dto.addresses.AddressDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserWithAddressDTO {

    private Long id;

    private String email;

    private String phone_number;

    private String first_name;

    private String second_name;

    private String patronymic;

    private AddressDTO addressDTO;
}
