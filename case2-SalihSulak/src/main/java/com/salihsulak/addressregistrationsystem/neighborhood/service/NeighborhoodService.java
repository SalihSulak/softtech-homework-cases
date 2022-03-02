package com.salihsulak.addressregistrationsystem.neighborhood.service;

import com.salihsulak.addressregistrationsystem.district.entity.Disctrict;
import com.salihsulak.addressregistrationsystem.district.service.entityservice.DisctrictEntityService;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodNameDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodSaveDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.UpdateNeighborhoodDto;
import com.salihsulak.addressregistrationsystem.neighborhood.entity.Neighborhood;
import com.salihsulak.addressregistrationsystem.neighborhood.service.entityservice.NeighborhoodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {

    private final NeighborhoodEntityService neighborhoodEntityService;
    private final DisctrictEntityService disctrictEntityService;

    public NeighborhoodDto saveNeighborhood(NeighborhoodDto neighborhoodDto){
        Disctrict disctrict =  disctrictEntityService.findById(neighborhoodDto.getDisctrictId());

        Neighborhood neighborhood = new Neighborhood();
        neighborhood.setName(neighborhoodDto.getName());
        neighborhood.setDisctrict(disctrict);

        neighborhoodEntityService.save(neighborhood);

        return neighborhoodDto;
    }

    public List<NeighborhoodSaveDto> listAllNeighborhoodByDisctrictId(UUID disctrictId){

        return neighborhoodEntityService.listAllNeighborhoodsByDisctrictId(disctrictId);
    }

    public UpdateNeighborhoodDto updateNeighborhoodName(UUID id, NeighborhoodNameDto neighborhoodDto){

        UpdateNeighborhoodDto updateNeighborhoodDto = new UpdateNeighborhoodDto();

        updateNeighborhoodDto.setId(id);
        updateNeighborhoodDto.setName(neighborhoodDto.getNeighborhoodName());

        return neighborhoodEntityService.update(updateNeighborhoodDto);
    }

}
