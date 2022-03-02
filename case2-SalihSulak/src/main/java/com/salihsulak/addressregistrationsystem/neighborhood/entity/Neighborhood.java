package com.salihsulak.addressregistrationsystem.neighborhood.entity;

import com.salihsulak.addressregistrationsystem.district.entity.Disctrict;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Neighborhood {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "disctrict_id")
    private Disctrict disctrict;


}
