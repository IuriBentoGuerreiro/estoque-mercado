package com.iuri.estoquemercado.model;

import com.iuri.estoquemercado.dto.VendaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venda")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "cliente")
    private String cliente;
    @OneToMany
    private List<ItemVenda> itensVendidos;

    public static Venda conveterParaVenda(VendaRequest vendaRequest){
        return Venda.builder()
                .data(LocalDate.now())
                .cliente(vendaRequest.getCliente())
                .build();
    }
}