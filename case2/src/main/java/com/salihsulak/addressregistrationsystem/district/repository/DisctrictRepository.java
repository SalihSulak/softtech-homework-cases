package com.salihsulak.addressregistrationsystem.district.repository;

import com.salihsulak.addressregistrationsystem.district.entity.Disctrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DisctrictRepository extends JpaRepository<Disctrict, UUID> {

    List<Disctrict> findAllByCity_PlateCode(String plateCode);


}
