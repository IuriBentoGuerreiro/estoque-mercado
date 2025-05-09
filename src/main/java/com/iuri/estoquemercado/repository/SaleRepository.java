package com.iuri.estoquemercado.repository;

import com.iuri.estoquemercado.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
