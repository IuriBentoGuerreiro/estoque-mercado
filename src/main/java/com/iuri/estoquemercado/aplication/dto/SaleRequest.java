package com.iuri.estoquemercado.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {

    private List<SaleItemRequest> saleItems;
}
