package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.VendaRequest;
import com.iuri.estoquemercado.dto.VendaResponse;
import com.iuri.estoquemercado.model.Venda;
import com.iuri.estoquemercado.repository.VendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaResponse salvarVenda(VendaRequest vendaRequest){
        return VendaResponse.converterParaResponse(vendaRepository
                .save(Venda.conveterParaVenda(vendaRequest)));
    }

    public List<VendaResponse> listar(){
        return vendaRepository.findAll().stream()
                .map(VendaResponse::converterParaResponse).toList();
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