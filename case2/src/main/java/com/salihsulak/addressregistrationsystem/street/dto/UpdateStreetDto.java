package com.salihsulak.addressregistrationsystem.street.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateStreetDto {
    UUID id;
    String name;
}
