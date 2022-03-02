package com.salihsulak.addressregistrationsystem.address.repository;

import com.salihsulak.addressregistrationsystem.address.dto.AddressDto;
import com.salihsulak.addressregistrationsystem.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    @Query("SELECT NEW com.salihsulak.addressregistrationsystem.address.dto.AddressDto(a.id,a.doorNumber,a.apartmentNumber,a.street.id,a.street.neighborhood.id,a.street.neighborhood.disctrict.id,a.street.neighborhood.disctrict.city.plateCode,a.street.neighborhood.disctrict.city.country.countryCode) FROM Address a WHERE a.id=?1")
    Optional<AddressDto> getAllAddressInformation(UUID id);
}
