package com.salihsulak.addressregistrationsystem.street.service.entityservice;

import com.salihsulak.addressregistrationsystem.neighborhood.dto.UpdateNeighborhoodDto;
import com.salihsulak.addressregistrationsystem.neighborhood.entity.Neighborhood;
import com.salihsulak.addressregistrationsystem.neighborhood.exceptions.NeighborhoodNotFoundException;
import com.salihsulak.addressregistrationsystem.neighborhood.service.entityservice.NeighborhoodEntityService;
import com.salihsulak.addressregistrationsystem.street.converter.StreetConverter;
import com.salihsulak.addressregistrationsystem.street.dto.StreetSaveDto;
import com.salihsulak.addressregistrationsystem.street.dto.UpdateStreetDto;
import com.salihsulak.addressregistrationsystem.street.entity.Street;
import com.salihsulak.addressregistrationsystem.street.exceptions.StreetNotFoundException;
import com.salihsulak.addressregistrationsystem.street.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StreetEntityService {

    private final StreetRepository streetRepository;
    private final NeighborhoodEntityService neighborhoodEntityService;

    public Street save(Street street){
        return streetRepository.save(street);
    }


    public List<StreetSaveDto> listAllStreetByNeighborhood(UUID neighborhoodId) {

        if (neighborhoodEntityService.isNeighborhoodExist(neighborhoodId)) {
            List<Street> streetList = streetRepository.findAllByNeighborhood_Id(neighborhoodId);
            if (!streetList.isEmpty())
                return StreetConverter.convertToStreetSaveDtoList(streetList);
            else
                throw new StreetNotFoundException();
        }
        else
            throw new NeighborhoodNotFoundException();
        }

    public Street findById(UUID id){
        Optional<Street> street = streetRepository.findById(id);
        if (street.isPresent())
            return street.get();
        else
            throw new StreetNotFoundException();
    }

    public UpdateStreetDto update(UpdateStreetDto updateStreetDto){

        Street street = this.findById(updateStreetDto.getId());
        street.setName(updateStreetDto.getName());

        streetRepository.save(street);

        return updateStreetDto;
    }
}
