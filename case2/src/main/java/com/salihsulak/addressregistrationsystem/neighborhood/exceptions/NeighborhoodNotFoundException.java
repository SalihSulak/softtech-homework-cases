package com.salihsulak.addressregistrationsystem.neighborhood.exceptions;

import org.webjars.NotFoundException;

public class NeighborhoodNotFoundException extends NotFoundException {
    public NeighborhoodNotFoundException() {
        super("Neighborhood Not Found!");
    }
}
