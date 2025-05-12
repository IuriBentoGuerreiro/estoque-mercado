package com.iuri.estoquemercado.infrastructure.repository;

import com.iuri.estoquemercado.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
