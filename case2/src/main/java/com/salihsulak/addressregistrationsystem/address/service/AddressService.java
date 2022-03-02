package com.salihsulak.addressregistrationsystem.address.service;

import com.salihsulak.addressregistrationsystem.address.dto.AddressDto;
import com.salihsulak.addressregistrationsystem.address.dto.AddressSaveDto;
import com.salihsulak.addressregistrationsystem.address.entity.Address;
import com.salihsulak.addressregistrationsystem.address.exceptions.AddressNotFoundException;
import com.salihsulak.addressregistrationsystem.address.service.entityservice.AddressEntityService;
import com.salihsulak.addressregistrationsystem.street.entity.Street;
import com.salihsulak.addressregistrationsystem.street.service.entityservice.StreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressEntityService addressEntityService;
    private final StreetEntityService streetEntityService;

    public AddressDto save(AddressSaveDto addressSaveDto){

        Address address = new Address();

        address.setApartmentNumber(addressSaveDto.getApartmentNumber());
        address.setDoorNumber(addressSaveDto.getDoorNumber());

        Street street = streetEntityService.findById(addressSaveDto.getStreetId());
        address.setStreet(street);

        Address savedAddress = addressEntityService.save(address);

        return addressEntityService.findById(savedAddress.getId());
    }

    public AddressDto findById(UUID id){
        return addressEntityService.findById(id);
    }

    public void delete(UUID id){

        if (addressEntityService.isAddressExist(id))
            addressEntityService.deleteAddress(id);

        else
            throw new AddressNotFoundException();
    }
}
