package com.salihsulak.addressregistrationsystem.city.entity;

import com.salihsulak.addressregistrationsystem.country.entity.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    private String plateCode;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_code" )
    private Country country;

}
