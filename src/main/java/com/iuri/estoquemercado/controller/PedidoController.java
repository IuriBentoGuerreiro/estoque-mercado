package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.PedidoRequest;
import com.iuri.estoquemercado.dto.PedidoResponse;
import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> salvar(@RequestBody PedidoRequest pedidoRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PedidoResponse.converter(Pedido.converter(pedidoRequest)));
    }
}
