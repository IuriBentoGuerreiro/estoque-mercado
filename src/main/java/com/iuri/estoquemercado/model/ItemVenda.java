package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.ItemVendaRequest;
import com.iuri.estoquemercado.dto.ItemVendaResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "item_venda")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @ManyToOne
    private Produto produto;

    public static ItemVenda conveterParaItemVenda(ItemVendaRequest itemVendaRequest){
        return ItemVenda.builder()
                .quantidade(itemVendaRequest.getQuantidade())
                .produto(itemVendaRequest.getProduto())
                .build();
    }
}