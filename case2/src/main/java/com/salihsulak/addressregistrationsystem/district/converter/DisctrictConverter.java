package com.salihsulak.addressregistrationsystem.district.converter;

import com.salihsulak.addressregistrationsystem.city.dto.CityDto;
import com.salihsulak.addressregistrationsystem.city.entity.City;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictDto;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictSaveDto;
import com.salihsulak.addressregistrationsystem.district.entity.Disctrict;

import java.util.ArrayList;
import java.util.List;

public class DisctrictConverter {

    public static DisctrictDto convertToDisctrictDto(Disctrict disctrict){

        return new DisctrictDto(disctrict.getName(),disctrict.getCity().getPlateCode());
    }
    public static List<DisctrictDto> convertToDisctrictDtoList(List<Disctrict> disctrictList){

        List<DisctrictDto> disctrictDtoList = new ArrayList<>(disctrictList.size());

        disctrictList.forEach(v->{
            DisctrictDto disctrictDto = convertToDisctrictDto(v);
            disctrictDtoList.add(disctrictDto);
        });

        return disctrictDtoList;
    }
}
