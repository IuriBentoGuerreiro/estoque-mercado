package com.iuri.estoquemercado.repository;

import com.iuri.estoquemercado.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
