package com.iuri.estoquemercado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iuri.estoquemercado.dto.PedidoRequest;
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
    @JsonBackReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pedido> pedido;

    public static Venda converter(VendaRequest vendaRequest){
        return Venda.builder()
                .data(LocalDate.now())
                .pedido(vendaRequest.getPedidos().stream().map(Pedido::converter).toList())
                .build();
    }
}