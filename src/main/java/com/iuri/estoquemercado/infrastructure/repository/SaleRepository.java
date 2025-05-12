package com.iuri.estoquemercado.infrastructure.repository;

import com.iuri.estoquemercado.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
