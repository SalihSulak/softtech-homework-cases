package com.salihsulak.addressregistrationsystem.city.converter;

import com.salihsulak.addressregistrationsystem.city.dto.CityDto;
import com.salihsulak.addressregistrationsystem.city.entity.City;

public class CityConverter {
    public static CityDto convertToCityDto(City city){

        CityDto cityDto = new CityDto();

        cityDto.setPlateCode(city.getPlateCode());
        cityDto.setCityName(city.getCityName());
        cityDto.setCountryCode(city.getCountry().getCountryCode());

        return cityDto;
    }
}
