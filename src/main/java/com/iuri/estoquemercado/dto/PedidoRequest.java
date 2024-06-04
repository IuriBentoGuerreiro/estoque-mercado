package com.iuri.estoquemercado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    public Integer idProduto;
    private Integer quantidade;
    private BigDecimal precoTotal;
    private Integer IdProduto;
    public String cliente;
}
