package com.iuri.estoquemercado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {

    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco_total")
    private BigDecimal precoTotal;
}