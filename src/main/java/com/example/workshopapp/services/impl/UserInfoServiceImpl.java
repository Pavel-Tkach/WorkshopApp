package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.users.UserInfoDTO;
import com.example.workshopapp.entities.User;
import com.example.workshopapp.repositories.UserInfoRepository;
import com.example.workshopapp.services.UserInfoService;
import com.example.workshopapp.utils.mappers.user.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoMapper mapper;

    private final UserInfoRepository userInfoRepository;


    @Override
    public UserInfoDTO findById(Long id) {
        User user = userInfoRepository.findById(id);
        return mapper.toDto(user);
    }
}
