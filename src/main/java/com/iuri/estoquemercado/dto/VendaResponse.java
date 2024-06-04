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
    private LocalDate data;
    private List<Pedido> pedidos;

    public static VendaResponse converter(Venda venda){
        return VendaResponse.builder()
                .id(venda.getId())
                .data(LocalDate.now())
                .pedidos(venda.getPedido())
                .build();
    }
}