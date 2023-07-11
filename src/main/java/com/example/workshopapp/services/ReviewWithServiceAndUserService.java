package com.example.workshopapp.services;

import com.example.workshopapp.dto.review.ReviewInfoDTO;

import java.util.List;

public interface ReviewWithServiceAndUserService {

    List<ReviewInfoDTO> findAllReviewsById(Long id);
}
