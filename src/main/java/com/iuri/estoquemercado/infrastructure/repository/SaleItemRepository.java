package com.iuri.estoquemercado.infrastructure.repository;

import com.iuri.estoquemercado.domain.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {
}
