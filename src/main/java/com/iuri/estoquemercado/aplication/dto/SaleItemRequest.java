package com.iuri.estoquemercado.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemRequest {

    private Integer productId;
    private Integer quantity;
}
