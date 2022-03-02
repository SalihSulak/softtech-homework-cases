package com.salihsulak.addressregistrationsystem.country.service;

import com.salihsulak.addressregistrationsystem.country.entity.Country;
import com.salihsulak.addressregistrationsystem.country.service.entityservice.CountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryEntityService countryEntityService;

    public Country saveCountry(Country country){
        return countryEntityService.save(country);
    }

    public Country findById(Short countryCode){

        return countryEntityService.findById(countryCode);
    }


}
