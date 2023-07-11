package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Review;

import java.util.List;

public interface ReviewWithServiceAndUserRepository {

    List<Review> findAllReviewsById(Long id);
}
