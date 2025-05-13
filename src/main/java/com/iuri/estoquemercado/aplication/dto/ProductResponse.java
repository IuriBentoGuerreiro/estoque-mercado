package com.iuri.estoquemercado.aplication.dto;

import com.iuri.estoquemercado.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Integer id;
    private String name;
    private Integer stockQuantity;
    private BigDecimal price;
    private Boolean isActive;

    public static ProductResponse convert(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .stockQuantity(product.getStockQuantity())
                .price(product.getPrice())
                .isActive(product.getIsActive())
                .build();
    }
}