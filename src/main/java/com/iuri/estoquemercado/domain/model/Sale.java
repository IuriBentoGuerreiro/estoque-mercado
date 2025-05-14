package com.iuri.estoquemercado.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> items;

    public void calculateTotal() {
        this.totalAmount = this.items.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(SaleItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo");
        }

        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
        item.setSale(this);
        calculateTotal();
    }
}