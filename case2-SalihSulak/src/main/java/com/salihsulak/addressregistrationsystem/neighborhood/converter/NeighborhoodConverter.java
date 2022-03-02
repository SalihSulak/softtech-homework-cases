package com.salihsulak.addressregistrationsystem.neighborhood.converter;


import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodSaveDto;
import com.salihsulak.addressregistrationsystem.neighborhood.entity.Neighborhood;

import java.util.ArrayList;
import java.util.List;

public class NeighborhoodConverter {
    public static NeighborhoodSaveDto convertToNeighborhoodSaveDto(Neighborhood neighborhood){

        NeighborhoodSaveDto neighborhoodSaveDto = new NeighborhoodSaveDto();

        neighborhoodSaveDto.setId(neighborhood.getId());
        neighborhoodSaveDto.setName(neighborhood.getName());
        neighborhoodSaveDto.setDisctrictId(neighborhood.getDisctrict().getId());

        return neighborhoodSaveDto;
    }

    public static List<NeighborhoodSaveDto> convertToNeighborhoodSaveDtoList(List<Neighborhood> neighborhoodList){

        List<NeighborhoodSaveDto> saveDtoList = new ArrayList<>(neighborhoodList.size());

        neighborhoodList.forEach(v->{
            NeighborhoodSaveDto neighborhoodSaveDto = convertToNeighborhoodSaveDto(v);
            saveDtoList.add(neighborhoodSaveDto);
        });
        return saveDtoList;
    }
}
