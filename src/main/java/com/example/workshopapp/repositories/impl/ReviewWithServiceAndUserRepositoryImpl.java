package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Review;
import com.example.workshopapp.repositories.ReviewWithServiceAndUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewWithServiceAndUserRepositoryImpl implements ReviewWithServiceAndUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Review> findAllReviewsById(Long id) {
        TypedQuery<Review> reviews = entityManager.createQuery("SELECT r FROM Review r JOIN FETCH r.service s JOIN FETCH r.user u WHERE r.id = :id", Review.class)
                .setParameter("id", id);
        return reviews.getResultList();
    }
}
