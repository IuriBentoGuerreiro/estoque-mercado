package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponse {

    private Integer id;
    private LocalDate data;
    private Produto IdProduto;
    private String cliente;
    private Pedido pedido;

    public static VendaResponse converterParaResponse(Venda venda){
        return VendaResponse.builder()
                .id(venda.getId())
                .data(LocalDate.now())
                .IdProduto(venda.getProduto())
                .cliente(venda.getCliente())
                .pedido(venda.getPedidos())
                .build();
    }
}