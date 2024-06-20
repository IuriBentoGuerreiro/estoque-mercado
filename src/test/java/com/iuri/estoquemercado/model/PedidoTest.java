package com.iuri.estoquemercado.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoTest {

    @Mock
    Pedido pedido;

    @Test
    void converterTest() {
        Produto produto = new Produto(1, "nome",1, BigDecimal.valueOf(10));
        when(pedido.getCliente()).thenReturn("pessoa");
        when(pedido.getQuantidade()).thenReturn(1);
        when(pedido.getPrecoTotal()).thenReturn(BigDecimal.valueOf(10));
        when(pedido.getProduto()).thenReturn(produto).thenReturn(produto);

        assertEquals("pessoa", pedido.getCliente());
        assertEquals(1, pedido.getQuantidade());
        assertEquals(BigDecimal.valueOf(10), pedido.getPrecoTotal());
        assertEquals(pedido.getProduto(), produto);
    }
}