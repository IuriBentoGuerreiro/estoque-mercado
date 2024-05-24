package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.VendaRequest;
import com.iuri.estoquemercado.dto.VendaResponse;
import com.iuri.estoquemercado.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Venda")
@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Operation(summary = "Salvar")
    @PostMapping
    public ResponseEntity<String> salvarVenda(@RequestBody VendaRequest vendaRequest){
        var vendaResponse = vendaService.salvarVenda(vendaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Venda Realizada");
    }

    @Operation(summary = "Listar")
    @GetMapping
    public ResponseEntity<List<VendaResponse>> listar(){
        var  listaVendas = vendaService.listar();
        return ResponseEntity.ok().body(listaVendas);
    }

    @Operation(summary = "Pegar por id")
    @GetMapping("/{id}")
    public ResponseEntity<VendaResponse> pegarPorId(@PathVariable Integer id){
        var venda = vendaService.pegarPorId(id);
        return ResponseEntity.ok().body(VendaResponse.converterParaResponse(venda));
    }

    @Operation(summary = "Atualizar")
    @PutMapping("/{id}")
    public ResponseEntity<VendaResponse> atualizar
            (@PathVariable Integer id, @RequestBody VendaRequest vendaRequest){
        var vendaSalva = vendaService.atualizar(id, vendaRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(VendaResponse.converterParaResponse(vendaSalva));
    }

    @Operation(summary = "Deletar")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        vendaService.deletar(id);
    }
}