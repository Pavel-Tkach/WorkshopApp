package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Service;

import java.util.List;

public interface ServiceInfoRepository {

    List<Service> findAll();
}
