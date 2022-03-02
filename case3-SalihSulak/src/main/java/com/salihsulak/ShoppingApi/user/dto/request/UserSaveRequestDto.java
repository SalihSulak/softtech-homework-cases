package com.salihsulak.ShoppingApi.user.dto.request;

import com.salihsulak.ShoppingApi.user.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveRequestDto {

    private String username;

    private String mailAddress;

    private String phoneNumber;

    private Role role;
}
