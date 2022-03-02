package com.salihsulak.ShoppingApi.user.converter;

import com.salihsulak.ShoppingApi.user.dto.request.UserSaveRequestDto;
import com.salihsulak.ShoppingApi.user.dto.response.UserResponseDto;
import com.salihsulak.ShoppingApi.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequestDto userSaveRequestDto);

    UserResponseDto convertToResponse(User user);

     List<UserResponseDto> convertToResponseList(List<User> userList);
}
