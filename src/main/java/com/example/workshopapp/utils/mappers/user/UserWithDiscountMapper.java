package com.example.workshopapp.utils.mappers.user;

import com.example.workshopapp.dto.discounts.DiscountInfoDTO;
import com.example.workshopapp.dto.users.UserWithDiscountDTO;
import com.example.workshopapp.entities.Discount;
import com.example.workshopapp.entities.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserWithDiscountMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(UserWithDiscountDTO.class, User.class)
                .addMappings(m -> m.skip(User::setDiscounts))
                .setPostConverter(toUserConverter());
        mapper.createTypeMap(User.class, UserWithDiscountDTO.class)
                .addMappings(m -> m.skip(UserWithDiscountDTO::setDiscountDTOList))
                .setPostConverter(toUserWithDiscountConverter());
    }

    private Converter<UserWithDiscountDTO, User> toUserConverter() {
        return context -> {
            UserWithDiscountDTO source = context.getSource();
            User destination = context.getDestination();
            mapUserSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapUserSpecificFields(UserWithDiscountDTO source, User destination) {
        List<Discount> discounts = toDiscountEntity(source.getDiscountDTOList());
        destination.setDiscounts(discounts);
    }

    private Converter<User, UserWithDiscountDTO> toUserWithDiscountConverter() {
        return context -> {
            User source = context.getSource();
            UserWithDiscountDTO destination = context.getDestination();
            mapUserWithDiscountSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapUserWithDiscountSpecificFields(User source, UserWithDiscountDTO destination) {
        List<DiscountInfoDTO> discountInfoDTOList = toDiscountDto(source.getDiscounts());
        destination.setDiscountDTOList(discountInfoDTOList);
    }

    private List<Discount> toDiscountEntity(List<DiscountInfoDTO> discountDTOList) {
        List<Discount> discountList = discountDTOList
                .stream()
                .map(discount -> Objects.isNull(discount) ? null : mapper.map(discount, Discount.class))
                .toList();

        return discountList;
    }

    private List<DiscountInfoDTO> toDiscountDto(List<Discount> discounts) {
        List<DiscountInfoDTO> discountDtoList = discounts
                .stream()
                .map(discount -> Objects.isNull(discount) ? null : mapper.map(discount, DiscountInfoDTO.class))
                .toList();

        return discountDtoList;
    }

    public UserWithDiscountDTO toDto(User entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, UserWithDiscountDTO.class);
    }

    public User toEntity(UserWithDiscountDTO dto, List<Discount> discount){
        User user =  Objects.isNull(dto) ? null : mapper.map(dto, User.class);
        user.setDiscounts(discount);
        return user;
    }

    public List<UserWithDiscountDTO> toUserWithDiscountDtoList(List<User> users){
        List<UserWithDiscountDTO> userWithDiscountDTOList = users
                .stream()
                .map(user -> Objects.isNull(user) ? null : mapper.map(user, UserWithDiscountDTO.class))
                .toList();

        return userWithDiscountDTOList;
    }
}
