package com.salihsulak.addressregistrationsystem.address.service.entityservice;

import com.salihsulak.addressregistrationsystem.address.dto.AddressDto;
import com.salihsulak.addressregistrationsystem.address.entity.Address;
import com.salihsulak.addressregistrationsystem.address.exceptions.AddressNotFoundException;
import com.salihsulak.addressregistrationsystem.address.repository.AddressRepository;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressEntityService {

    private final AddressRepository addressRepository;

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public AddressDto findById(UUID id){

        Optional<AddressDto> address = addressRepository.getAllAddressInformation(id);

        if (address.isPresent())
            return address.get();
        else
            throw new AddressNotFoundException();
    }

    public void deleteAddress(UUID id){
        addressRepository.deleteById(id);
    }

    public boolean isAddressExist(UUID id){
        return addressRepository.existsById(id);
    }

}
