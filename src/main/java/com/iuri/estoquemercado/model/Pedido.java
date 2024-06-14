package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.PedidoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;
    @NotBlank
    @Column(name = "cliente")
    private String cliente;
    @NotNull
    @Column(name = "quantidade")
    private Integer quantidade;
    @DecimalMin(value = "1")
    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    public static Pedido converter(PedidoRequest pedidoRequest){
        return Pedido.builder()
                .produto(new Produto(pedidoRequest.getIdProduto()))
                .quantidade(pedidoRequest.getQuantidade())
                .cliente(pedidoRequest.getCliente())
                .build();
    }
}