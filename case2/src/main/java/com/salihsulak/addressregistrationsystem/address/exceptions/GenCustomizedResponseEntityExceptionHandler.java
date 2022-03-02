package com.salihsulak.addressregistrationsystem.address.exceptions;

import com.salihsulak.addressregistrationsystem.neighborhood.exceptions.NeighborhoodNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.util.Date;

@RestController
@ControllerAdvice
public class GenCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> notFoundExceptions(NotFoundException exception, WebRequest webRequest){

        Date errorDate = new Date();
        String message = exception.getMessage();
        String description = webRequest.getDescription(false);

        GenExceptionResponse exceptionResponse = new GenExceptionResponse(errorDate,message,description);

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }


}

