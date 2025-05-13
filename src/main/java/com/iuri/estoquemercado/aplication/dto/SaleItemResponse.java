package com.iuri.estoquemercado.aplication.dto;

import com.iuri.estoquemercado.domain.model.Product;
import com.iuri.estoquemercado.domain.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemResponse {

    private Integer id;
    private Integer quantity;
    private Sale sale;
    private Product product;
}
