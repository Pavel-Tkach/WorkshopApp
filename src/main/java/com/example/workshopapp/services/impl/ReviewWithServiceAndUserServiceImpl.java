package com.example.workshopapp.services.impl;

import com.example.workshopapp.dto.review.ReviewInfoDTO;
import com.example.workshopapp.repositories.ReviewWithServiceAndUserRepository;
import com.example.workshopapp.services.ReviewWithServiceAndUserService;
import com.example.workshopapp.utils.mappers.review.ReviewInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewWithServiceAndUserServiceImpl implements ReviewWithServiceAndUserService {

    private final ReviewInfoMapper mapper;

    private final ReviewWithServiceAndUserRepository reviewWithServiceAndUserRepository;

    @Override
    public List<ReviewInfoDTO> findAllReviewsById(Long id) {
        return mapper.toReviewInfoDtoList(reviewWithServiceAndUserRepository.findAllReviewsById(id));
    }
}
