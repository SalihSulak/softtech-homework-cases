package com.salihsulak.addressregistrationsystem.district.service;

import com.salihsulak.addressregistrationsystem.city.entity.City;
import com.salihsulak.addressregistrationsystem.city.exceptions.CityNotFoundException;
import com.salihsulak.addressregistrationsystem.city.service.CityService;
import com.salihsulak.addressregistrationsystem.city.service.entityservice.CityEntityService;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictDto;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictSaveDto;
import com.salihsulak.addressregistrationsystem.district.entity.Disctrict;
import com.salihsulak.addressregistrationsystem.district.exceptions.DiscrictNotFoundException;
import com.salihsulak.addressregistrationsystem.district.service.entityservice.DisctrictEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DisctrictService {

    private final DisctrictEntityService disctrictEntityService;
    private final CityEntityService cityEntityService;

    public DisctrictDto saveDisctrict(DisctrictDto disctrictDto){
        City city = cityEntityService.findById(disctrictDto.getCityPlateCode());
        Disctrict disctrict = new Disctrict();
        disctrict.setName(disctrictDto.getName());
        disctrict.setCity(city);
        disctrictEntityService.save(disctrict);
        return disctrictDto;
    }

    public List<DisctrictDto> listAllDisctrictByPlateCode(String plateCode){
        if (cityEntityService.isCityExist(plateCode)){
            List<DisctrictDto> disctrictList = disctrictEntityService.listAllDisctrictByPlateCode(plateCode);
            if (!disctrictList.isEmpty())
                return disctrictList;
            else
                throw new DiscrictNotFoundException();
        }
        else
            throw new CityNotFoundException();
    }

    public Disctrict findById(UUID id){
        return disctrictEntityService.findById(id);
    }

}
