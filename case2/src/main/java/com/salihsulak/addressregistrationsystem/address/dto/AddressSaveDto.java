package com.salihsulak.addressregistrationsystem.address.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressSaveDto {

    private int apartmentNumber;
    private int doorNumber;
    private UUID streetId;

}
