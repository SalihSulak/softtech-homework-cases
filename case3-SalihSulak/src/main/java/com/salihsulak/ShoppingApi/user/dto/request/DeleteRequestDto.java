package com.salihsulak.ShoppingApi.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteRequestDto {
    private String username;
    private String phoneNumber;
}
