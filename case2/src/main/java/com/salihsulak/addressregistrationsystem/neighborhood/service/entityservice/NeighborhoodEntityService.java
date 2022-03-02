package com.salihsulak.addressregistrationsystem.neighborhood.service.entityservice;

import com.salihsulak.addressregistrationsystem.district.exceptions.DiscrictNotFoundException;
import com.salihsulak.addressregistrationsystem.district.service.entityservice.DisctrictEntityService;
import com.salihsulak.addressregistrationsystem.neighborhood.converter.NeighborhoodConverter;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodSaveDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.UpdateNeighborhoodDto;
import com.salihsulak.addressregistrationsystem.neighborhood.entity.Neighborhood;
import com.salihsulak.addressregistrationsystem.neighborhood.exceptions.NeighborhoodNotFoundException;
import com.salihsulak.addressregistrationsystem.neighborhood.repository.NeighborhoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NeighborhoodEntityService {

    private final NeighborhoodRepository neighborhoodRepository;
    private final DisctrictEntityService disctrictEntityService;

    public Neighborhood save(Neighborhood neighborhood){
        return neighborhoodRepository.save(neighborhood);
    }


    public List<NeighborhoodSaveDto> listAllNeighborhoodsByDisctrictId(UUID disctrictId) {

        if (disctrictEntityService.isDisctrictExist(disctrictId)) {
            List<Neighborhood> neighborhoodList = neighborhoodRepository.findAllByDisctrict_Id(disctrictId);

            if (!neighborhoodList.isEmpty())
                return NeighborhoodConverter.convertToNeighborhoodSaveDtoList(neighborhoodList);

            else
                throw new NeighborhoodNotFoundException();
        }

        else
            throw new DiscrictNotFoundException();
    }

    public Neighborhood findById(UUID neighborhoodId) {

        Optional<Neighborhood> neighborhood = neighborhoodRepository.findById(neighborhoodId);

        if(neighborhood.isPresent())
            return neighborhood.get();

        else
            throw new NeighborhoodNotFoundException();

    }
    public UpdateNeighborhoodDto update(UpdateNeighborhoodDto updateNeighborhoodDto){

        Neighborhood neighborhood = this.findById(updateNeighborhoodDto.getId());
        neighborhood.setName(updateNeighborhoodDto.getName());

        neighborhoodRepository.save(neighborhood);

        return updateNeighborhoodDto;
        }

    public boolean isNeighborhoodExist(UUID id){
        return neighborhoodRepository.existsById(id);
    }

}
