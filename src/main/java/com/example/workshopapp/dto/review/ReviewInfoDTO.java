package com.example.workshopapp.dto.review;

import com.example.workshopapp.dto.service.ServiceInfoDTO;
import com.example.workshopapp.dto.users.UserInfoDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReviewInfoDTO {

    private Long id;

    private String review;

    private float rate;

    private UserInfoDTO user;

    private ServiceInfoDTO service;
}
