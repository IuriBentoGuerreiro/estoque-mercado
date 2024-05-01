package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.ItemVendaRequest;
import com.iuri.estoquemercado.dto.ItemVendaResponse;
import com.iuri.estoquemercado.dto.VendaRequest;
import com.iuri.estoquemercado.model.ItemVenda;
import com.iuri.estoquemercado.model.Venda;
import com.iuri.estoquemercado.repository.ItemVendaRepository;
import com.iuri.estoquemercado.repository.VendaRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    private ItemVendaRepository itemVendaRepository;

    public Venda salvarVenda(VendaRequest vendaRequest){
        return vendaRepository.save(Venda.conveterParaVenda(vendaRequest));
    }
}
