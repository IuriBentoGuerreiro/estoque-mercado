package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.VendaRequest;
import com.iuri.estoquemercado.dto.VendaResponse;
import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.model.Venda;
import com.iuri.estoquemercado.repository.PedidoRepository;
import com.iuri.estoquemercado.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public VendaService(VendaRepository vendaRepository, PedidoRepository pedidoRepository) {
        this.vendaRepository = vendaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public VendaResponse salvarVenda(VendaRequest vendaRequest){
        var venda = vendaRepository.save(Venda.builder()
                        .data(LocalDate.now())
                        .pedido(vendaRequest.getPedidos().stream().map(Pedido::converter).toList())
                .build());

        return VendaResponse.converter(venda);
    }

    public List<VendaResponse> listar(){
        return vendaRepository.findAll().stream()
                .map(VendaResponse::converter).toList();
    }

    public Venda pegarPorId(Integer id){
        return vendaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Recurso não encontrado")
        );
    }

    public Venda atualizar(Integer id, VendaRequest vendaRequest){
        Venda vendaSalva = pegarPorId(id);
        BeanUtils.copyProperties(vendaRequest, vendaSalva, "id");
        return vendaRepository.save(vendaSalva);
    }

    public void deletar(Integer id){
        vendaRepository.deleteById(id);
    }
}