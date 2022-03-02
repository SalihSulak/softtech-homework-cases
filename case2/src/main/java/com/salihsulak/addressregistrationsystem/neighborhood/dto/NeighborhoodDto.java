package com.salihsulak.addressregistrationsystem.neighborhood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class NeighborhoodDto {
    private String name;
    private UUID disctrictId;
}
