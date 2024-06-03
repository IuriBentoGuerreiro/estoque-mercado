package com.iuri.estoquemercado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;
    @Column(name = "data")
    private LocalDate data;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedido;

    public static Venda conveterParaVenda(VendaRequest vendaRequest){
        return Venda.builder()
                .produto(new Produto(vendaRequest.idProduto))
                .data(LocalDate.now())
                .pedido(vendaRequest.getPedidos())
                .build();
    }
}