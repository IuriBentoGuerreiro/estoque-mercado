package com.iuri.estoquemercado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProdutoInsuficienteException extends RuntimeException{

    public ProdutoInsuficienteException(String ex){
        super(ex);
    }
}
