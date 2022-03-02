package com.salihsulak.addressregistrationsystem.district.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DisctrictSaveDto {

    private UUID id;
    private String name;
    private String cityPlateCode;

}
