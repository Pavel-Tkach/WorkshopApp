package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.User;

public interface UserWithAddressRepository {

    User findByIdUserWithAddress(Long id);
}
