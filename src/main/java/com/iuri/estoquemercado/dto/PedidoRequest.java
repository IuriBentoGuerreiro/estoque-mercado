package com.iuri.estoquemercado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    private Integer idProduto;
    private Integer quantidade;
    private String cliente;
}
