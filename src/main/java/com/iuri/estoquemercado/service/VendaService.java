package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.VendaRequest;
import com.iuri.estoquemercado.dto.VendaResponse;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.model.Venda;
import com.iuri.estoquemercado.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public VendaResponse salvarVenda(VendaRequest vendaRequest){
        var venda = vendaRepository.save(Venda.builder()
                        .data(LocalDate.now())
                        .produto(new Produto(vendaRequest.idProduto))
                        .pedido(vendaRequest.getPedidos())
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