package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Service;
import com.example.workshopapp.repositories.ServiceInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceInfoRepositoryImpl implements ServiceInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Service> findAll() {
        TypedQuery<Service> servicesInfo = entityManager.createQuery("SELECT s FROM Service s", Service.class);
        return servicesInfo.getResultList();
    }
}
