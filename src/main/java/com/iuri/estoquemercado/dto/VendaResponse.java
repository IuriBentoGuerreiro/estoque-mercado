package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.ItemVenda;
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
    private String cliente;
    private List<ItemVenda> itensVendidos;

    public static VendaResponse converterParaResponse(Venda venda){
        return VendaResponse.builder()
                .id(venda.getId())
                .data(LocalDate.now())
                .cliente(venda.getCliente())
                .itensVendidos(venda.getItensVendidos())
                .build();
    }
}
