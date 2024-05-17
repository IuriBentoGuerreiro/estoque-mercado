package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.ItemVenda;
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
    private ItemVenda itemVenda;
}