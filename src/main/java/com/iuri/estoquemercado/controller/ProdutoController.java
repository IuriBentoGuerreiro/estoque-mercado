package com.iuri.estoquemercado.controller;

import com.iuri.estoquemercado.dto.ProdutoRequest;
import com.iuri.estoquemercado.dto.ProdutoResponse;
import com.iuri.estoquemercado.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse salvar(@RequestBody ProdutoRequest produtoRequest){
        return ProdutoResponse.converterParaResponse(produtoService.salvar(produtoRequest));
    }

    @Operation(summary = "Pegar por id")
    @GetMapping("/{id}")
    public ProdutoResponse pegarPorId(@PathVariable Integer id){
        return ProdutoResponse.converterParaResponse(produtoService.pegarPorId(id));
    }

    @Operation(summary = "Listar")
    @GetMapping
    public List<ProdutoResponse> listar(){
        return produtoService.listar();
    }

    @Operation(summary = "Atualizar")
    @PutMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest){
        return ProdutoResponse.converterParaResponse(produtoService.atualizar(id, produtoRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        produtoService.deletar(id);
    }
}