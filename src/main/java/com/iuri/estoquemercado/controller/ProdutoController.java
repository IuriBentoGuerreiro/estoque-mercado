package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.ProdutoRequest;
import com.iuri.estoquemercado.dto.ProdutoResponse;
import com.iuri.estoquemercado.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "produto")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Operation(summary = "Salvar")
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody ProdutoRequest produtoRequest){
        var produto = produtoService.salvar(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body
                (ProdutoResponse.converterParaResponse(produto));
    }

    @Operation(summary = "Pegar por id")
    @GetMapping("/{id}")
    public ProdutoResponse pegarPorId(@PathVariable Integer id){
        return ProdutoResponse.converterParaResponse(produtoService.pegarPorId(id));
    }

    @Operation(summary = "Listar")
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar(){
        var listaProduto = produtoService.listar();
        return ResponseEntity.ok().body(listaProduto);
    }

    @Operation(summary = "Atualizar")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar
            (@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest){
        var produtoSalvo = produtoService.atualizar(id, produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProdutoResponse.converterParaResponse(produtoSalvo));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        produtoService.deletar(id);
    }
}