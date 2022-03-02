package com.salihsulak.addressregistrationsystem.street.repository;

import com.salihsulak.addressregistrationsystem.street.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StreetRepository extends JpaRepository<Street, UUID> {
    List<Street> findAllByNeighborhood_Id(UUID id);
}
