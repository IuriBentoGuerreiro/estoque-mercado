package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.ItemVendaRequest;
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
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    public static ItemVenda converterParaItemVenda(ItemVendaRequest itemVendaRequest){
        return ItemVenda.builder()
                .quantidade(itemVendaRequest.getQuantidade())
                .precoTotal(itemVendaRequest.getPrecoTotal())
                .build();
    }
}