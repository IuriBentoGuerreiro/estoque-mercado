package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.PedidoRequest;
import com.iuri.estoquemercado.dto.PedidoResponse;
import com.iuri.estoquemercado.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedido")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Operation(summary = "salvar")
    @PostMapping
    public ResponseEntity<PedidoResponse> salvar(@Valid @RequestBody PedidoRequest pedidoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(pedidoRequest));
    }

    @Operation(summary = "listar")
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listar(){
        return ResponseEntity.ok().body(pedidoService.listar());
    }

    @Operation(summary = "pegar por id")
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> pegarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(PedidoResponse.converter(pedidoService.pegarPorId(id)));
    }

    @Operation(summary = "deletar")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        pedidoService.deletar(id);
    }
}
