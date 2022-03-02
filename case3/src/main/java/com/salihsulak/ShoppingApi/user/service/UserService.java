package com.salihsulak.ShoppingApi.user.service;

import com.salihsulak.ShoppingApi.user.converter.UserMapper;
import com.salihsulak.ShoppingApi.user.dto.request.UpdateUserInfoRequestDto;
import com.salihsulak.ShoppingApi.user.dto.request.UserSaveRequestDto;
import com.salihsulak.ShoppingApi.user.dto.response.UserResponseDto;
import com.salihsulak.ShoppingApi.user.entity.User;
import com.salihsulak.ShoppingApi.user.enums.Role;
import com.salihsulak.ShoppingApi.user.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;

    public UserResponseDto saveUser(UserSaveRequestDto saveRequest){
        User user = UserMapper.INSTANCE.convertToUser(saveRequest);
        userEntityService.save(user);
        return UserMapper.INSTANCE.convertToResponse(user);
    }

    public List<UserResponseDto> listUsers(String username){
        List<User> userList = username != null ? List.of(userEntityService.findByUsername(username)) : userEntityService.listAllUsers();
        return UserMapper.INSTANCE.convertToResponseList(userList);
    }

    public UserResponseDto findById(UUID id){
        User user = userEntityService.findById(id);
        return UserMapper.INSTANCE.convertToResponse(user);
    }

    public boolean deleteByUsernameAndPhoneNumber(String username, String phoneNumber){
        return userEntityService.deleteByUsernameAndPhoneNumber(username,phoneNumber);
    }
    public UserResponseDto updateUserInformation(UUID id, UpdateUserInfoRequestDto userInfo){

        User user = provideUserByIdAndFillItFromUpdateDto(id,userInfo);
        userEntityService.save(user);
        return UserMapper.INSTANCE.convertToResponse(user);
    }

    private User provideUserByIdAndFillItFromUpdateDto(UUID id,UpdateUserInfoRequestDto userInfo){
        User user = userEntityService.findById(id);
        if(userInfo.getUsername()!=null)
            user.setUsername(userInfo.getUsername());
        if(userInfo.getMailAddress()!=null)
            user.setMailAddress(userInfo.getMailAddress());
        if (userInfo.getPhoneNumber()!=null)
            user.setPhoneNumber(userInfo.getPhoneNumber());
        return user;
    }
}
