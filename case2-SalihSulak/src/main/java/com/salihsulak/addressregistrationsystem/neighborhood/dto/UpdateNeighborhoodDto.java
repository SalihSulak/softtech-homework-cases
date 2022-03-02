package com.salihsulak.addressregistrationsystem.neighborhood.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateNeighborhoodDto {
    UUID id;
    String name;
}
