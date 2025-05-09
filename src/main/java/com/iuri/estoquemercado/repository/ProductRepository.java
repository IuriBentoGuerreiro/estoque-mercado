package com.iuri.estoquemercado.repository;

import com.iuri.estoquemercado.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
