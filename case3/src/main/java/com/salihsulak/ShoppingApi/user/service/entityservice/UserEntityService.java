package com.salihsulak.ShoppingApi.user.service.entityservice;


import com.salihsulak.ShoppingApi.generic.exceptions.GenericBusinessException;
import com.salihsulak.ShoppingApi.user.entity.User;
import com.salihsulak.ShoppingApi.user.enums.UserErrorMessage;
import com.salihsulak.ShoppingApi.user.exceptions.UsernameAndPhoneNumberNotMatch;
import com.salihsulak.ShoppingApi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final UserRepository userRepository;

    public void save(User user) {
        try {
            userRepository.save(user);
        }
        catch (Exception e) {
            throw new GenericBusinessException(UserErrorMessage.USER_SAVE_FAIL);
        }
    }

    public List<User> listAllUsers(){
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty())
            throw new GenericBusinessException(UserErrorMessage.USER_NOT_FOUND);
        return userList;
    }

    public User findById(UUID id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else
            throw new GenericBusinessException(UserErrorMessage.USER_NOT_FOUND);
    }

    public User findByUsername(String username){
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent())
            return byUsername.get();
        else
            throw new GenericBusinessException(UserErrorMessage.USER_NOT_FOUND);
    }
    public boolean deleteByUsernameAndPhoneNumber(String username, String phoneNumber){
        if(isUsernameExist(username)) {
            User user = findByUsernameAndPhoneNumber(username, phoneNumber);
            userRepository.delete(user);
            return true;
        }
        else
            throw new GenericBusinessException(UserErrorMessage.USER_NOT_FOUND);
    }
    public User findByUsernameAndPhoneNumber(String username, String phoneNumber){
        return userRepository.findByUsernameAndPhoneNumber(username, phoneNumber).orElseThrow(()-> new UsernameAndPhoneNumberNotMatch(username,phoneNumber));
    }
    public boolean isUsernameExist(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean userExistById(UUID id){return userRepository.existsById(id);}

    public String findUsernameById(UUID id){return userRepository.findUsernameById(id);}
}
