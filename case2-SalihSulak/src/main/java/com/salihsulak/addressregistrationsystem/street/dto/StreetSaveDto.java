package com.salihsulak.addressregistrationsystem.street.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StreetSaveDto {
    private String name;
    private UUID neighborhoodId;
}
