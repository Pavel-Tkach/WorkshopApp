package com.example.workshopapp.repositories;

import com.example.workshopapp.entities.Discount;

import java.util.List;

public interface DiscountRepository {

    List<Discount> findAllDiscounts();
}
