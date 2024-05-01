package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.ProdutoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidadeEstoque")
    private Integer quantidadeEstoque;
    @Column(name = "preco")
    private BigDecimal preco;

    public static Produto converterParaProduto(ProdutoRequest produtoRequest){
        return Produto.builder()
                .nome(produtoRequest.getNome())
                .quantidadeEstoque(produtoRequest.getQuantidadeEstoque())
                .preco(produtoRequest.getPreco())
                .build();
    }
}