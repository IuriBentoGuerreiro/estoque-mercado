package com.iuri.estoquemercado.aplication.dto;

import com.iuri.estoquemercado.domain.model.Sale;
import com.iuri.estoquemercado.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {

    private Integer id;
    private String client;
    private Integer quantity;
    private BigDecimal totalPrice;
    private Product product;

    public static SaleResponse convert(Sale sale){
        return SaleResponse.builder()
                .id(sale.getId())
                .client(sale.getClient())
                .quantity(sale.getQuantity())
                .totalPrice(sale.getTotalPrice())
                .product(sale.getProduct())
                .build();
    }
}
