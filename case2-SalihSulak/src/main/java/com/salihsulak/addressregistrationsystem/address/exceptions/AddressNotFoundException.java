package com.salihsulak.addressregistrationsystem.address.exceptions;

import org.webjars.NotFoundException;

public class AddressNotFoundException extends NotFoundException {
    public AddressNotFoundException(){
        super("Address Not Found");
    }
}
