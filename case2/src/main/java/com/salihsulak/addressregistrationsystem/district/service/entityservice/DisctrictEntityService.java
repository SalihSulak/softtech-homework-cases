package com.salihsulak.addressregistrationsystem.district.service.entityservice;

import com.salihsulak.addressregistrationsystem.district.converter.DisctrictConverter;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictDto;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictSaveDto;
import com.salihsulak.addressregistrationsystem.district.entity.Disctrict;
import com.salihsulak.addressregistrationsystem.district.exceptions.DiscrictNotFoundException;
import com.salihsulak.addressregistrationsystem.district.repository.DisctrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DisctrictEntityService {

    private final DisctrictRepository disctrictRepository;

    public Disctrict save(Disctrict disctrict){
        return disctrictRepository.save(disctrict);
    }

    public List<DisctrictDto> listAllDisctrictByPlateCode(String plateCode){
        List<Disctrict> disctrictList = disctrictRepository.findAllByCity_PlateCode(plateCode);
        return DisctrictConverter.convertToDisctrictDtoList(disctrictList);
    }

    public Disctrict findById(UUID id) {

        Optional<Disctrict> disctrict = disctrictRepository.findById(id);

        if (disctrict.isPresent())
            return disctrict.get();
        else
            throw new DiscrictNotFoundException();
    }

    public boolean isDisctrictExist(UUID id){
        return disctrictRepository.existsById(id);
    }

}
