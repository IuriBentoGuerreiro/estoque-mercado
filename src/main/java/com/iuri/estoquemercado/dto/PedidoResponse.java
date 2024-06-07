package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Integer id;
    private Produto produto;
    private String cliente;
    private Integer quantidade;
    private BigDecimal precoTotal;

    public static PedidoResponse converter(Pedido pedido){
        return PedidoResponse.builder()
                .id(pedido.getId())
                .produto(pedido.getProduto())
                .cliente(pedido.getCliente())
                .quantidade(pedido.getQuantidade())
                .precoTotal(pedido.getProduto().getPreco())
                .build();
    }
}
