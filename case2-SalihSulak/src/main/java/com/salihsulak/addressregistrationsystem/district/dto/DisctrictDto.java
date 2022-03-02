package com.salihsulak.addressregistrationsystem.district.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DisctrictDto{

    private String name;
    private String cityPlateCode;
}
