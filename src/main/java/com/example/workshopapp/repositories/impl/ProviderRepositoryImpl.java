package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Provider;
import com.example.workshopapp.repositories.ProviderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderRepositoryImpl implements ProviderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Provider> findAllProviders() {
        TypedQuery<Provider> providers = entityManager.createQuery("SELECT p FROM Provider p", Provider.class);
        return providers.getResultList();
    }
}
