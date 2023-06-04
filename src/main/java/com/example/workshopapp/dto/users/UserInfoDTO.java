package com.example.workshopapp.dto.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfoDTO {

    private Long id;

    private String first_name;

    private String second_name;

    private String patronymic;
}
