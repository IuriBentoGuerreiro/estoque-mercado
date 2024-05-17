package com.iuri.estoquemercado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemVenda {

    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "preco_total")
    private BigDecimal precoTotal;
}