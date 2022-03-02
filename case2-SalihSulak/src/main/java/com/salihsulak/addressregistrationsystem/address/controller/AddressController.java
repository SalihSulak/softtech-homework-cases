package com.salihsulak.addressregistrationsystem.address.controller;

import com.salihsulak.addressregistrationsystem.address.dto.AddressDto;
import com.salihsulak.addressregistrationsystem.address.dto.AddressSaveDto;
import com.salihsulak.addressregistrationsystem.address.service.AddressService;

import com.salihsulak.addressregistrationsystem.city.dto.CityDto;
import com.salihsulak.addressregistrationsystem.city.service.CityService;
import com.salihsulak.addressregistrationsystem.country.entity.Country;
import com.salihsulak.addressregistrationsystem.country.service.CountryService;
import com.salihsulak.addressregistrationsystem.district.dto.DisctrictDto;

import com.salihsulak.addressregistrationsystem.district.service.DisctrictService;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodNameDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.NeighborhoodSaveDto;
import com.salihsulak.addressregistrationsystem.neighborhood.dto.UpdateNeighborhoodDto;

import com.salihsulak.addressregistrationsystem.neighborhood.service.NeighborhoodService;
import com.salihsulak.addressregistrationsystem.street.dto.StreetNameDto;
import com.salihsulak.addressregistrationsystem.street.dto.StreetSaveDto;
import com.salihsulak.addressregistrationsystem.street.dto.UpdateStreetDto;
import com.salihsulak.addressregistrationsystem.street.service.StreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AddressController {

    private final CountryService countryService;
    private final CityService cityService;
    private final DisctrictService disctrictService;
    private final NeighborhoodService neighborhoodService;
    private final StreetService streetService;
    private final AddressService addressService;

    @PostMapping("countries")
    public ResponseEntity saveCountry(@RequestBody Country country){

        Country savedCountry = countryService.saveCountry(country);

        return ResponseEntity.ok(savedCountry);
    }

    @GetMapping("countries/{countryId}")
    public ResponseEntity findByCountryCode(@PathVariable short countryId){

        Country country = countryService.findById(countryId);

        return ResponseEntity.ok(country);
    }

    @PostMapping("cities")
    public ResponseEntity saveCity(@RequestBody CityDto cityDto){

        CityDto savedCity = cityService.saveCity(cityDto);

        return ResponseEntity.ok(savedCity);
    }

    @GetMapping("cities/{plateCode}")
    public ResponseEntity findByPlateCode(@PathVariable String plateCode){

            CityDto city = cityService.findById(plateCode);

            return ResponseEntity.ok(city);

    }

    @PostMapping("disctrits")
        public ResponseEntity saveDisctricts(@RequestBody DisctrictDto disctrictDto){

        DisctrictDto savedDisctrict = disctrictService.saveDisctrict(disctrictDto);

        return ResponseEntity.ok(savedDisctrict);
    }

    @GetMapping("disctrits")
    public ResponseEntity listDisctrictsByPlateCode(@RequestParam("plate_code") String plateCode){

        List<DisctrictDto> disctrictList = disctrictService.listAllDisctrictByPlateCode(plateCode);

        return ResponseEntity.ok(disctrictList);
    }

    @PostMapping("neighborhoods")
    public ResponseEntity saveNeighborhood(@RequestBody NeighborhoodDto neighborhoodDto){

        NeighborhoodDto saveNeighborhood = neighborhoodService.saveNeighborhood(neighborhoodDto);

        return ResponseEntity.ok(saveNeighborhood);
    }

    @PatchMapping("neigborhoods/{neighborhoodId}")
    public ResponseEntity updateNeighborhoodName(@PathVariable UUID neighborhoodId,@RequestBody NeighborhoodNameDto neigborhoodNameDto){

        UpdateNeighborhoodDto updateNeighborhoodDto = neighborhoodService.updateNeighborhoodName(neighborhoodId, neigborhoodNameDto);

        return ResponseEntity.ok(updateNeighborhoodDto);
    }


    @GetMapping("neighborhoods")
    public ResponseEntity listAllNeighborhoodByDisctrictId(@RequestParam("disctrict_id") UUID disctrictId){

        List<NeighborhoodSaveDto> neighborhoods = neighborhoodService.listAllNeighborhoodByDisctrictId(disctrictId);

        return ResponseEntity.ok(neighborhoods);
    }

    @PostMapping("streets")
    public ResponseEntity saveStreet(@RequestBody StreetSaveDto streetSaveDto){

        StreetSaveDto saveStreet = streetService.save(streetSaveDto);

        return ResponseEntity.ok(saveStreet);
    }

    @GetMapping("streets")
    public ResponseEntity listAllStreetsByNeighborhoodId(@RequestParam("neighborhood_id") UUID neighborhoodId){

        List<StreetSaveDto> streetList = streetService.listAllStreetByNeighborhood(neighborhoodId);

        return ResponseEntity.ok(streetList);
    }

    @PatchMapping("streets/{streetId}")
    public ResponseEntity updateStreetName(@RequestParam("street_id") UUID streetId, @RequestBody StreetNameDto streetNameDto){

        UpdateStreetDto updateStreetDto = streetService.updateStreetName(streetId, streetNameDto);

        return ResponseEntity.ok(updateStreetDto);
    }

    @PostMapping("address")
    public ResponseEntity saveAddress(@RequestBody AddressSaveDto addressSaveDto){

        AddressDto addressDto = addressService.save(addressSaveDto);

        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("address/{addressId}")
    public ResponseEntity getAddressById(@PathVariable UUID addressId){

        AddressDto address = addressService.findById(addressId);

        return ResponseEntity.ok(address);
    }

    @DeleteMapping("address/{addressId}")
    public ResponseEntity delete(@PathVariable UUID addressId){

        addressService.delete(addressId);

        return ResponseEntity.ok("Address Deleted");
    }

}
