package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.User;

public interface UserInfoRepository {

    User findById(Long id);
}