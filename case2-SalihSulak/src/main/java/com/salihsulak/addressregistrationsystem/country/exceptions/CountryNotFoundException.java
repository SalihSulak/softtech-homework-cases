package com.salihsulak.addressregistrationsystem.country.exceptions;

import org.webjars.NotFoundException;

public class CountryNotFoundException extends NotFoundException {
    public CountryNotFoundException() {
        super("Country Not Found!");
    }
}
