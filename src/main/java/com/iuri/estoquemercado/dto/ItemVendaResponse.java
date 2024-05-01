package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.ItemVenda;
import com.iuri.estoquemercado.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaResponse {

    private Integer id;
    private Integer quantidade;

    public static ItemVendaResponse converterParaResponse(ItemVenda itemVenda){
        return ItemVendaResponse.builder()
                .id(itemVenda.getId())
                .quantidade(itemVenda.getQuantidade())
                .build();
    }
}