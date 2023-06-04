package com.example.workshopapp.dto.addresses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String city;

    private String street;

    private String house;
}
