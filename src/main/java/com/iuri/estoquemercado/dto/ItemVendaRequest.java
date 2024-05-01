package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaRequest {

    private Integer quantidade;
    private Produto produto;
}
