package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.VendaRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venda")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "cliente")
    private String cliente;
    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;
    @Embedded
    private ItemVenda itemVenda;

    public static Venda conveterParaVenda(VendaRequest vendaRequest){
        return Venda.builder()
                .data(LocalDate.now())
                .cliente(vendaRequest.getCliente())
                .itemVenda(vendaRequest.getItemVenda())
                .produto(new Produto(vendaRequest.getIdProduto()))
                .build();
    }
}