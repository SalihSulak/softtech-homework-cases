package com.salihsulak.ShoppingApi.user.controller;

import com.salihsulak.ShoppingApi.generic.dto.RestResponse;
import com.salihsulak.ShoppingApi.user.dto.request.UpdateUserInfoRequestDto;
import com.salihsulak.ShoppingApi.user.dto.request.UserSaveRequestDto;
import com.salihsulak.ShoppingApi.user.dto.response.UserResponseDto;
import com.salihsulak.ShoppingApi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<RestResponse<UserResponseDto>> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        UserResponseDto user = userService.saveUser(userSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(user));
    }

    @GetMapping()
    public ResponseEntity <RestResponse<List<UserResponseDto>>> listAll(@RequestParam(required = false, name = "username") String username) {
            List<UserResponseDto> userList = userService.listUsers(username);
            return ResponseEntity.ok(RestResponse.of(userList));
    }

    @GetMapping("{userId}")
    public ResponseEntity<RestResponse<UserResponseDto>> findUserById(@PathVariable UUID userId){
        UserResponseDto user = userService.findById(userId);
        return ResponseEntity.ok(RestResponse.of(user));
    }

    @DeleteMapping()
    public RestResponse<Boolean> deleteUserByUsernameAndPhoneNumber(@RequestParam(name = "username") String username, @RequestParam(name = "phoneNumber") String phoneNumber){
        return RestResponse.of(userService.deleteByUsernameAndPhoneNumber(username,phoneNumber));
    }
    @PatchMapping("{userId}")
    public ResponseEntity<RestResponse<UserResponseDto>> updateUserInformation(@PathVariable UUID userId, @RequestBody UpdateUserInfoRequestDto userInformation){
        UserResponseDto user = userService.updateUserInformation(userId, userInformation);
        return ResponseEntity.ok(RestResponse.of(user));
    }

}
