package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponse {

    private Integer id;
    private Produto produto;
    private LocalDate data;
    private List<Pedido> pedidos;

    public static VendaResponse converterParaResponse(Venda venda){
        return VendaResponse.builder()
                .id(venda.getId())
                .produto(venda.getProduto())
                .data(LocalDate.now())
                .pedidos(venda.getPedido())
                .build();
    }
}