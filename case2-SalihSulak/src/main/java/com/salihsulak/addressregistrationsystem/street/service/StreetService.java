package com.salihsulak.addressregistrationsystem.street.service;


import com.salihsulak.addressregistrationsystem.neighborhood.entity.Neighborhood;
import com.salihsulak.addressregistrationsystem.neighborhood.service.entityservice.NeighborhoodEntityService;
import com.salihsulak.addressregistrationsystem.street.dto.StreetNameDto;
import com.salihsulak.addressregistrationsystem.street.dto.StreetSaveDto;
import com.salihsulak.addressregistrationsystem.street.dto.UpdateStreetDto;
import com.salihsulak.addressregistrationsystem.street.entity.Street;
import com.salihsulak.addressregistrationsystem.street.service.entityservice.StreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StreetService {

    private final StreetEntityService streetEntityService;
    private final NeighborhoodEntityService neighborhoodEntityService;

    public StreetSaveDto save(StreetSaveDto streetSaveDto){

        Neighborhood neighborhood =  neighborhoodEntityService.findById(streetSaveDto.getNeighborhoodId());

        Street street = new Street();
        street.setName(streetSaveDto.getName());
        street.setNeighborhood(neighborhood);

        streetEntityService.save(street);

        return streetSaveDto;
    }

    public List<StreetSaveDto> listAllStreetByNeighborhood(UUID neighborhoodId){

        return streetEntityService.listAllStreetByNeighborhood(neighborhoodId);
    }

    public UpdateStreetDto updateStreetName(UUID id, StreetNameDto streetNameDto){

        UpdateStreetDto updateStreetDto = new UpdateStreetDto();

        updateStreetDto.setId(id);
        updateStreetDto.setName(streetNameDto.getStreetName());

        return streetEntityService.update(updateStreetDto);
    }

    public Street findById(UUID id){
        return streetEntityService.findById(id);
    }
}
