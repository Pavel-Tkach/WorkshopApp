package com.example.workshopapp.controllers;

import com.example.workshopapp.dto.review.ReviewInfoDTO;
import com.example.workshopapp.dto.service.ServiceInfoDTO;
import com.example.workshopapp.dto.service.ServiceWithRepairPartDTO;
import com.example.workshopapp.services.ReviewWithServiceAndUserService;
import com.example.workshopapp.services.ServiceInfoService;
import com.example.workshopapp.services.ServiceWithRepairPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceInfoService serviceInfoService;

    private final ServiceWithRepairPartService serviceWithRepairPartService;

    private final ReviewWithServiceAndUserService reviewWithServiceAndUserService;

    @GetMapping("/")
    public List<ServiceInfoDTO> getAllServiceInfo(){
        return serviceInfoService.findAllServiceInfo();
    }

    @GetMapping("/{id}/recommended_parts")
    public List<ServiceWithRepairPartDTO> findByIdServiceWithRepairParts(@PathVariable("id") Long id){
        return serviceWithRepairPartService.findByIdServiceWithRepairParts(id);
    }

    @GetMapping("/{id}/reviews")
    public List<ReviewInfoDTO> findAllReviewsById(@PathVariable("id") Long id){
        return reviewWithServiceAndUserService.findAllReviewsById(id);
    }
}
