package com.salihsulak.ShoppingApi.user.entity;

import com.salihsulak.ShoppingApi.user.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(unique = true)
    private String username;

    @Column(name = "mail_address",unique = true)
    private String mailAddress;

    @Pattern(regexp="^[0-9]{10}$")
    @Column(name = "phone_number",unique = true )
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;
}
