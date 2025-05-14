package com.iuri.estoquemercado.aplication.dto;

import com.iuri.estoquemercado.domain.model.Sale;
import com.iuri.estoquemercado.domain.model.SaleItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {

    private Integer id;
    private String clientName;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private List<SaleItem> items;

    public static SaleResponse convert(Sale sale){
        return SaleResponse.builder()
                .id(sale.getId())
                .items(sale.getItems())
                .saleDate(sale.getSaleDate())
                .totalAmount(sale.getTotalAmount())
                .build();
    }
}
