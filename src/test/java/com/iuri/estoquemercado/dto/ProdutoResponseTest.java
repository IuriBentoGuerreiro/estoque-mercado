package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoResponseTest {

    @Test
    void converter() {
        Produto produto = new Produto(1, "produto", 1, BigDecimal.valueOf(10));

        ProdutoResponse response = ProdutoResponse.converter(produto);

        assertEquals(1, response.getId());
        assertEquals("produto", response.getNome());
        assertEquals(1, response.getQuantidadeEstoque());
        assertEquals(BigDecimal.valueOf(10), response.getPreco()) ;
    }
}