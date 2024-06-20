package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.ProdutoRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void converterTest() {
        ProdutoRequest request = new ProdutoRequest("produto", 10, BigDecimal.valueOf(10));
        Produto produto = Produto.converter(request);

        assertEquals("produto", produto.getNome());
        assertEquals(10, produto.getQuantidadeEstoque());
        assertEquals(BigDecimal.valueOf(10), produto.getPreco());
    }
}