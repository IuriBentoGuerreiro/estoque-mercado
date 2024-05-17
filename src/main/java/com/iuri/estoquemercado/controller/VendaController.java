package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.VendaRequest;
import com.iuri.estoquemercado.dto.VendaResponse;
import com.iuri.estoquemercado.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaResponse salvarVenda(@RequestBody VendaRequest vendaRequest){
        return vendaService.salvarVenda(vendaRequest);
    }

    @GetMapping
    public List<VendaResponse> listar(){
        return vendaService.listar();
    }
}