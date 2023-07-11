package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Service;

import java.util.List;

public interface ServiceWithRepairPartRepository {

    List<Service> findByIdServiceWithRepairParts(Long id);
}
