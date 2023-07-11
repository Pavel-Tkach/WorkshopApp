package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Provider;

import java.util.List;

public interface ProviderRepository {

    List<Provider> findAllProviders();
}
