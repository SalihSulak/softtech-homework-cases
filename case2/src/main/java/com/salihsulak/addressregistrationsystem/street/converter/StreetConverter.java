package com.salihsulak.addressregistrationsystem.street.converter;


import com.salihsulak.addressregistrationsystem.street.dto.StreetSaveDto;
import com.salihsulak.addressregistrationsystem.street.entity.Street;

import java.util.ArrayList;
import java.util.List;

public class StreetConverter {
    public static StreetSaveDto convertToStreetSaveDto(Street street){

        StreetSaveDto streetSaveDto = new StreetSaveDto();

        streetSaveDto.setName(street.getName());
        streetSaveDto.setNeighborhoodId(street.getNeighborhood().getId());

        return streetSaveDto;
    }

    public static List<StreetSaveDto> convertToStreetSaveDtoList(List<Street> streetList){

        List<StreetSaveDto> saveDtoList = new ArrayList<>(streetList.size());

        streetList.forEach(v->{
            StreetSaveDto streetSaveDto = convertToStreetSaveDto(v);
            saveDtoList.add(streetSaveDto);
        });
        return saveDtoList;
    }
}
