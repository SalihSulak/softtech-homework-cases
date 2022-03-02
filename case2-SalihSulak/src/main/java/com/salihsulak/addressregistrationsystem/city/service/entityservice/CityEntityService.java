package com.salihsulak.addressregistrationsystem.city.service.entityservice;

import com.salihsulak.addressregistrationsystem.city.entity.City;
import com.salihsulak.addressregistrationsystem.city.exceptions.CityNotFoundException;
import com.salihsulak.addressregistrationsystem.city.repository.CityRepository;
import com.salihsulak.addressregistrationsystem.country.entity.Country;
import com.salihsulak.addressregistrationsystem.country.exceptions.CountryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityEntityService {

    private final CityRepository cityRepository;

    public City save(City city) {
        return cityRepository.save(city);
    }

    public City findById(String countryId) {

        Optional<City> city = cityRepository.findById(countryId);

        if(city.isPresent())
            return city.get();

        else
            throw new CityNotFoundException();

    }

    public boolean isCityExist(String plateCode){
        return cityRepository.existsById(plateCode);
    }
}
