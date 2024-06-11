package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.ProdutoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    @NotBlank
    private String nome;
    @Column(name = "quantidadeEstoque")
    @NotNull
    private Integer quantidadeEstoque;
    @Column(name = "preco")
    @NotNull
    private BigDecimal preco;

    public Produto(Integer idProduto){
        this.id = idProduto;
    }

    public static Produto converter(ProdutoRequest produtoRequest){
        return Produto.builder()
                .nome(produtoRequest.getNome())
                .quantidadeEstoque(produtoRequest.getQuantidadeEstoque())
                .preco(produtoRequest.getPreco())
                .build();
    }
}