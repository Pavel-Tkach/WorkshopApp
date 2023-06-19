package com.example.workshopapp.utils.mappers.user;

import com.example.workshopapp.dto.users.UserInfoDTO;
import com.example.workshopapp.entities.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(UserInfoDTO.class, User.class);
        mapper.createTypeMap(User.class, UserInfoDTO.class);
    }

    public UserInfoDTO toDto(User entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, UserInfoDTO.class);
    }

    public User toEntity(UserInfoDTO dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    public List<UserInfoDTO> toUserInfoDtoList(List<User> users){
        List<UserInfoDTO> userInfoDTOList = users
                .stream()
                .map(user -> Objects.isNull(user) ? null : mapper.map(user, UserInfoDTO.class))
                .toList();
        return userInfoDTOList;
    }

    public List<User> toUserList(List<UserInfoDTO> userInfoDTOList){
        List<User> users = userInfoDTOList
                .stream()
                .map(user -> Objects.isNull(user) ? null : mapper.map(user, User.class))
                .toList();
        return users;
    }
}
