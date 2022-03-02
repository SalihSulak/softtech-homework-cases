package com.salihsulak.ShoppingApi.user.dto.response;

import com.salihsulak.ShoppingApi.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private String username;
    private String mailAddress;
    private String phoneNumber;
    private Role role;
}
