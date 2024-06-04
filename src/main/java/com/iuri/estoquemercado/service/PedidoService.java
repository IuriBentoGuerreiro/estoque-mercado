package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.PedidoRequest;
import com.iuri.estoquemercado.dto.PedidoResponse;
import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoResponse salvar(PedidoRequest pedidoRequest){
        var pedido = pedidoRepository.save(Pedido.builder()
                        .produto(new Produto(pedidoRequest.getIdProduto()))
                        .cliente(pedidoRequest.getCliente())
                        .precoTotal(pedidoRequest.getPrecoTotal())
                        .quantidade(pedidoRequest.getQuantidade())
                .build());
        return PedidoResponse.converter(pedido);
    }
}
