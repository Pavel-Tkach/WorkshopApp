package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.User;

import java.util.List;

public interface UserWithDiscountsRepository {

    List<User> findByIdUserWithDiscounts(Long id);
}
