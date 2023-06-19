package com.example.workshopapp.utils.mappers.review;

import com.example.workshopapp.dto.review.ReviewInfoDTO;
import com.example.workshopapp.dto.service.ServiceInfoDTO;
import com.example.workshopapp.dto.users.UserInfoDTO;
import com.example.workshopapp.entities.Review;
import com.example.workshopapp.entities.Service;
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
public class ReviewInfoMapper {

    private final ModelMapper mapper;

    @PostConstruct
    public void setup(){
        mapper.createTypeMap(ReviewInfoDTO.class, Review.class)
                .addMappings(m -> m.skip(Review::setUser))
                .addMappings(m -> m.skip(Review::setService))
                .setPostConverter(toReviewConverter());
        mapper.createTypeMap(Review.class, ReviewInfoDTO.class)
                .addMappings(m -> m.skip(ReviewInfoDTO::setUserInfoDTO))
                .addMappings(m -> m.skip(ReviewInfoDTO::setServiceInfoDTO))
                .setPostConverter(toReviewInfoConverter());

    }

    private Converter<ReviewInfoDTO, Review> toReviewConverter() {
        return context -> {
            ReviewInfoDTO source = context.getSource();
            Review destination = context.getDestination();
            mapReviewSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapReviewSpecificFields(ReviewInfoDTO source, Review destination) {
        User user = toUserEntity(source.getUserInfoDTO());
        Service service = toServiceEntity(source.getServiceInfoDTO());
        destination.setUser(user);
        destination.setService(service);
    }

    private Converter<Review, ReviewInfoDTO> toReviewInfoConverter() {
        return context -> {
            Review source = context.getSource();
            ReviewInfoDTO destination = context.getDestination();
            mapReviewInfoSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapReviewInfoSpecificFields(Review source, ReviewInfoDTO destination) {
        UserInfoDTO userInfoDTO = toUserDto(source.getUser());
        ServiceInfoDTO serviceInfoDTO = toServiceDto(source.getService());
        destination.setUserInfoDTO(userInfoDTO);
        destination.setServiceInfoDTO(serviceInfoDTO);
    }

    private User toUserEntity(UserInfoDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    private Service toServiceEntity(ServiceInfoDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Service.class);
    }

    private UserInfoDTO toUserDto(User entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UserInfoDTO.class);
    }

    private ServiceInfoDTO toServiceDto(Service entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ServiceInfoDTO.class);
    }

    public ReviewInfoDTO toDto(Review entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, ReviewInfoDTO.class);
    }

    public Review toEntity(ReviewInfoDTO dto, Service service, User user){
        Review review =  Objects.isNull(dto) ? null : mapper.map(dto, Review.class);
        review.setService(service);
        review.setUser(user);
        return review;
    }

    public List<ReviewInfoDTO> toReviewInfoDtoList(List<Review> reviews){
        List<ReviewInfoDTO> reviewInfoDTOList = reviews
                .stream()
                .map(review -> Objects.isNull(review) ? null : mapper.map(review, ReviewInfoDTO.class))
                .toList();

        return reviewInfoDTOList;
    }
}
