package com.iuri.estoquemercado.repository;

import com.iuri.estoquemercado.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
