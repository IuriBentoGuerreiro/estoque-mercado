package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.ProdutoEstoqueFilter;
import com.iuri.estoquemercado.dto.ProdutoRequest;
import com.iuri.estoquemercado.dto.ProdutoResponse;
import com.iuri.estoquemercado.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public ResponseEntity<ProdutoResponse> salvar(@Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body
                (ProdutoResponse.converter(produtoService.salvar(produtoRequest)));
    }

    @Operation(summary = "Pegar por id")
    @GetMapping("/{id}")
    public ProdutoResponse pegarPorId(@PathVariable Integer id){
        return ProdutoResponse.converter(produtoService.pegarPorId(id));
    }

    @Operation(summary = "Listar")
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar(){
        return ResponseEntity.ok().body(produtoService.listar());
    }

    @Operation(summary = "Atualizar")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar
            (@PathVariable Integer id, @Valid @RequestBody ProdutoRequest produtoRequest){
        var produtoSalvo = produtoService.atualizar(id, produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProdutoResponse.converter(produtoSalvo));
    }

    @Operation(summary = "Deletar")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        produtoService.deletar(id);
    }

    @Operation(summary = "Atualiza estoque de produto")
    @PutMapping("/{id}/produto")
    public ResponseEntity<ProdutoResponse> atualizarEstoque(@PathVariable Integer id
            , @Valid @RequestBody ProdutoEstoqueFilter filter){
        var produto = produtoService.atualizarEstoque(id, filter);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}