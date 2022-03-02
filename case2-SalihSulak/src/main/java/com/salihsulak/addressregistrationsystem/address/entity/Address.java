package com.salihsulak.addressregistrationsystem.address.entity;

import com.salihsulak.addressregistrationsystem.street.entity.Street;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private int apartmentNumber;

    private int doorNumber;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;


}
