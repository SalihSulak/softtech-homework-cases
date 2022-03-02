package com.salihsulak.ShoppingApi.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserInfoRequestDto {

    private String username;

    private String mailAddress;

    private String phoneNumber;

}
