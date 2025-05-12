package com.iuri.estoquemercado.domain.model;

import com.iuri.estoquemercado.aplication.dto.SaleRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "sale")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;
    @NotBlank
    @Column(name = "client")
    private String client;
    @NotNull
    @Column(name = "quantity")
    private Integer quantity;
    @DecimalMin(value = "1")
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public static Sale convert(SaleRequest saleRequest){
        return Sale.builder()
                .product(new Product(saleRequest.getIdProduct()))
                .quantity(saleRequest.getQuantity())
                .client(saleRequest.getClient())
                .build();
    }
}