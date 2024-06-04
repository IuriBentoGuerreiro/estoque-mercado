package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.PedidoRequest;
import com.iuri.estoquemercado.dto.PedidoResponse;
import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService serviceRepository;

    @Transactional
    public PedidoResponse salvar(PedidoRequest pedidoRequest){
        var pedido = pedidoRepository.save(Pedido.builder()
                        .produto(serviceRepository.pegarPorId(pedidoRequest.getIdProduto()))
                        .quantidade(pedidoRequest.getQuantidade())
                        .precoTotal(pedidoRequest.getPrecoTotal())
                        .cliente(pedidoRequest.getCliente())
                .build());
        return PedidoResponse.converter(pedido);
    }

    public List<PedidoResponse> listar(){
        return pedidoRepository.findAll().stream().map(
                PedidoResponse::converter).toList();
    }

    public Pedido pegarPorId(Integer id){
        return pedidoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recurso não encontrado")
        );
    }

    public Pedido atualizar(Integer id, PedidoRequest pedidoRequest){
        var pedidoSalvo = pegarPorId(id);
        BeanUtils.copyProperties(pedidoRequest, pedidoSalvo, "id");
        return pedidoRepository.save(pedidoSalvo);
    }

    public void deletar(Integer id){
        pedidoRepository.deleteById(id);
    }
}
