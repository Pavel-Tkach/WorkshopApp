package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Device;
import com.example.workshopapp.repositories.DeviceInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceInfoRepositoryImpl implements DeviceInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Device> findAllDevices() {
        TypedQuery<Device> devices = entityManager.createQuery("SELECT d FROM Device d", Device.class);
        return devices.getResultList();
    }
}
