package com.example.workshopapp.repositories.impl;

import com.example.workshopapp.entities.Device;
import com.example.workshopapp.repositories.DeviceWithUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceWithUserRepositoryImpl implements DeviceWithUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Device findByIdDeviceWithUser(Long id) {
        TypedQuery<Device> device = entityManager.createQuery("SELECT d FROM Device d INNER JOIN d.user u WHERE  u.id = :id", Device.class)
                .setParameter("id", id);
        return device.getSingleResult();
    }
}
