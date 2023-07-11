package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.User;
import com.example.workshopapp.repositories.UserInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(Long id) {
        TypedQuery<User> user = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class).setParameter("id", id);
        return user.getSingleResult();
    }
}
