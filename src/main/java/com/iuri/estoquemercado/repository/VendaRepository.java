package com.iuri.estoquemercado.repository;

import com.iuri.estoquemercado.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
