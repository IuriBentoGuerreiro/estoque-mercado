package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequest {

    private LocalDate data;
    public Integer idProduto;
    private List<Pedido> pedidos;
}