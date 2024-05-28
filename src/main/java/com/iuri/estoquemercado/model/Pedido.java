package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.PedidoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "item_venda")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    public static Pedido converterParaItemVenda(PedidoRequest pedidoRequest){
        return Pedido.builder()
                .quantidade(pedidoRequest.getQuantidade())
                .precoTotal(pedidoRequest.getPrecoTotal())
                .build();
    }
}