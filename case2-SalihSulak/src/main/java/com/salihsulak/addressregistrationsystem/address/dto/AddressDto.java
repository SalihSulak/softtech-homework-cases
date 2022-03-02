package com.salihsulak.addressregistrationsystem.address.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    private UUID id;

    private int apartmentNumber;

    private int doorNumber;

    private UUID streetId;

    private UUID neighborhoodId;

    private UUID disctrictId;


    private String cityId;


    private short countryId;






}
