package com.iuri.estoquemercado.aplication.controller;

import com.iuri.estoquemercado.aplication.dto.SaleRequest;
import com.iuri.estoquemercado.aplication.dto.SaleResponse;
import com.iuri.estoquemercado.aplication.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sale")
@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Operation(summary = "save")
    @PostMapping
    public ResponseEntity<SaleResponse> saveSale(@Valid @RequestBody SaleRequest saleRequest) {
        SaleResponse saleResponse = saleService.saveSale(saleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleResponse);
    }

    @Operation(summary = "list")
    @GetMapping
    public ResponseEntity<List<SaleResponse>> listAllSales() {
        return ResponseEntity.ok().body(saleService.listAllSales());
    }

    @Operation(summary = "get by id")
    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getSaleById(@PathVariable Integer id) {
        return ResponseEntity.ok(SaleResponse.convert(saleService.getSaleById(id)));
    }

    @Operation(summary = "delete")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);

    }
}
