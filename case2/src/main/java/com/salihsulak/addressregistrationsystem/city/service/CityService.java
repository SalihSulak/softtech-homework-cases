package com.salihsulak.addressregistrationsystem.city.service;

import com.salihsulak.addressregistrationsystem.city.converter.CityConverter;
import com.salihsulak.addressregistrationsystem.city.dto.CityDto;
import com.salihsulak.addressregistrationsystem.city.entity.City;
import com.salihsulak.addressregistrationsystem.city.repository.CityRepository;
import com.salihsulak.addressregistrationsystem.city.service.entityservice.CityEntityService;
import com.salihsulak.addressregistrationsystem.country.entity.Country;
import com.salihsulak.addressregistrationsystem.country.service.CountryService;
import com.salihsulak.addressregistrationsystem.country.service.entityservice.CountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityEntityService cityEntityService;
    private final CountryEntityService countryEntityService;

    public CityDto saveCity(CityDto cityDto){

        City city = new City();

        city.setPlateCode(cityDto.getPlateCode());
        Country country = countryEntityService.findById(cityDto.getCountryCode());
        city.setCountry(country);
        city.setCityName(cityDto.getCityName());

        cityEntityService.save(city);

        return cityDto;
    }

    public CityDto findById(String plateCode){

        City city = cityEntityService.findById(plateCode);

        return CityConverter.convertToCityDto(city);
    }
}
