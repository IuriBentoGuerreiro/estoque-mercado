package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PedidoResponseTest {

    @Test
    void converterTest() {
        Produto produto = new Produto(1, "nome", 1, BigDecimal.valueOf(10));
        Pedido pedido = new Pedido(1, produto, "cliente",1, BigDecimal.valueOf(10));

        PedidoResponse response = PedidoResponse.converter(pedido);

        assertEquals(1, response.getId());
        assertEquals(produto, response.getProduto());
        assertEquals("cliente", response.getCliente());
        assertEquals(1, response.getQuantidade());
        assertEquals(BigDecimal.valueOf(10), response.getPrecoTotal());
    }
}