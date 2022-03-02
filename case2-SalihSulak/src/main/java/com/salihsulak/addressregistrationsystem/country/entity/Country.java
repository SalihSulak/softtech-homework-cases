package com.salihsulak.addressregistrationsystem.country.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Country {

    @Id
    private short countryCode;

    @Column
    private String name;

}
