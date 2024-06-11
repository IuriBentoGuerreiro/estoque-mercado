package com.iuri.estoquemercado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.webjars.NotFoundException;

import java.io.NotActiveException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //TODO revisar
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestHandler(BadRequestException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundHandler(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
