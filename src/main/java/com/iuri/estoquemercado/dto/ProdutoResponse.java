package com.iuri.estoquemercado.dto;

import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {

    private Integer id;
    private String nome;
    private Integer quantidadeEstoque;
    private BigDecimal preco;
    private Venda venda;

    public static ProdutoResponse converterParaResponse(Produto produto){
        return ProdutoResponse.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .quantidadeEstoque(produto.getQuantidadeEstoque())
                .preco(produto.getPreco())
                .build();
    }
}