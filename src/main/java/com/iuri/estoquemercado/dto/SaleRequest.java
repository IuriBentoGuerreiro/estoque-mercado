package com.iuri.estoquemercado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {

    private Integer idProduct;
    private Integer quantity;
    private String client;
}
