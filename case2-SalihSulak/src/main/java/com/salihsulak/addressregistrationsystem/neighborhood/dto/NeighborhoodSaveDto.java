package com.salihsulak.addressregistrationsystem.neighborhood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeighborhoodSaveDto {
    private UUID id;
    private String name;
    private UUID disctrictId;
}
