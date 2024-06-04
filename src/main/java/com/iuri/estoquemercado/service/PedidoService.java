package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.PedidoRequest;
import com.iuri.estoquemercado.dto.PedidoResponse;
import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.repository.PedidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoResponse salvar(PedidoRequest pedidoRequest){
        return PedidoResponse.converter(pedidoRepository.save(Pedido.converter(pedidoRequest)));
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
