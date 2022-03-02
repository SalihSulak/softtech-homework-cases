package com.salihsulak.addressregistrationsystem.street.exceptions;

import org.webjars.NotFoundException;

public class StreetNotFoundException extends NotFoundException {
    public StreetNotFoundException() {
        super("Street Not Found!");
    }
}
