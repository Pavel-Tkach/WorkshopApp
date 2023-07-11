package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.users.UserWithAddressDTO;
import com.example.workshopapp.entities.User;
import com.example.workshopapp.repositories.UserWithAddressRepository;
import com.example.workshopapp.services.UserWithAddressService;
import com.example.workshopapp.utils.mappers.user.UserWithAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserWithAddressServiceImpl implements UserWithAddressService {

    private final UserWithAddressRepository userWithAddressRepository;

    private final UserWithAddressMapper mapper;

    @Override
    public UserWithAddressDTO findByIdUserWithAddress(Long id) {
        User user = userWithAddressRepository.findByIdUserWithAddress(id);
        return mapper.toDto(user);
    }
}
