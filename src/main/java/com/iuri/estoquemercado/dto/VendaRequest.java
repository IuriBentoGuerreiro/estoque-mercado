package com.iuri.estoquemercado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequest {

    private LocalDate data;
    private String cliente;
    private Integer IdProduto;
    private ItemVendaRequest itemVenda;
}