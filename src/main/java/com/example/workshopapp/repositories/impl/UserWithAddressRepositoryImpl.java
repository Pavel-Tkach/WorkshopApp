package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.User;
import com.example.workshopapp.repositories.UserWithAddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserWithAddressRepositoryImpl implements UserWithAddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByIdUserWithAddress(Long id) {
        TypedQuery<User> user = entityManager.createQuery("SELECT u FROM User u INNER JOIN u.address a WHERE a.id = :id", User.class).setParameter("id", id);
        return user.getSingleResult();
    }
}
