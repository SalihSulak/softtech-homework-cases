package com.salihsulak.addressregistrationsystem.city.exceptions;

import org.webjars.NotFoundException;

public class CityNotFoundException extends NotFoundException {
    public CityNotFoundException() {
        super("City Not Found!");
    }
}
