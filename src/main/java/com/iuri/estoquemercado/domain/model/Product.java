package com.iuri.estoquemercado.domain.model;

import com.iuri.estoquemercado.aplication.dto.ProductRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "stock_quantity")
    @NotNull
    @Min(value = 0)
    private Integer stockQuantity;
    @Column(name = "price")
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;

    public Product(Integer idProduct){
        this.id = idProduct;
    }

    public static Product convert(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .stockQuantity(productRequest.getStockQuantity())
                .price(productRequest.getPrice())
                .build();
    }
}