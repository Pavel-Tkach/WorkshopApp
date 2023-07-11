package com.example.workshopapp.services;

import com.example.workshopapp.dto.users.UserWithAddressDTO;

public interface UserWithAddressService {

    UserWithAddressDTO findByIdUserWithAddress(Long id);
}
