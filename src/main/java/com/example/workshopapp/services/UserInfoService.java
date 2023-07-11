package com.example.workshopapp.services;

import com.example.workshopapp.dto.users.UserInfoDTO;

public interface UserInfoService {

    UserInfoDTO findById(Long id);
}
