package com.iuri.estoquemercado.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuri.estoquemercado.aplication.dto.SaleItemRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale_item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    @JsonIgnore
    private Sale sale;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public static SaleItem convert(SaleItemRequest saleItemRequest){
        return SaleItem.builder()
                .quantity(saleItemRequest.getQuantity())
                .product(new Product(saleItemRequest.getProductId()))
                .build();
    }
}
