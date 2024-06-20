package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.PedidoRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PedidoTest {

    @Test
    void converterTest() {
        PedidoRequest request = new PedidoRequest(1, 1, "cliente");
        Pedido pedido = Pedido.converter(request);

        assertEquals(1, pedido.getProduto().getId());
        assertEquals(1, pedido.getQuantidade());
        assertEquals("cliente", pedido.getCliente());
    }
}