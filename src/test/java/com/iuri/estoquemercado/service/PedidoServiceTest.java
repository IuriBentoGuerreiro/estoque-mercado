package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.PedidoRequest;
import com.iuri.estoquemercado.dto.PedidoResponse;
import com.iuri.estoquemercado.model.Pedido;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    void salvarTest() {
        Produto produto = new Produto(1, "Produto Teste", 1, BigDecimal.valueOf(10.0));
        PedidoRequest pedidoRequest = new PedidoRequest(1, 2, "Cliente Teste");

        when(produtoService.pegarPorId(1)).thenReturn(produto);

        when(pedidoRepository.save(any(Pedido.class))).thenAnswer(invocation -> {
            Pedido pedidoSalvo = invocation.getArgument(0);
            pedidoSalvo.setId(1);
            return pedidoSalvo;
        });

        PedidoResponse pedidoResponse = pedidoService.salvar(pedidoRequest);

        assertNotNull(pedidoResponse);

        verify(pedidoRepository, times(1)).save(any(Pedido.class));

    }

    @Test
    void listarTest() {
        Pedido pedido1 = new Pedido(1, new Produto(1, "Produto 1", 1, BigDecimal.valueOf(10.0)), "Cliente 1", 1, BigDecimal.valueOf(10.0));
        Pedido pedido2 = new Pedido(2, new Produto(2, "Produto 2", 2, BigDecimal.valueOf(20.0)), "Cliente 2", 2, BigDecimal.valueOf(40.0));
        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);

        when(pedidoRepository.findAll()).thenReturn(pedidos);

        List<PedidoResponse> listaPedidosResponse = pedidoService.listar();

        assertNotNull(listaPedidosResponse);
        assertEquals(2, listaPedidosResponse.size());

        verify(pedidoRepository, times(1)).findAll();

        assertEquals(1, listaPedidosResponse.get(0).getId());
        assertEquals("Produto 1", listaPedidosResponse.get(0).getProduto().getNome());
        assertEquals("Cliente 1", listaPedidosResponse.get(0).getCliente());
        assertEquals(1, listaPedidosResponse.get(0).getQuantidade());
        assertEquals(BigDecimal.valueOf(10.0), listaPedidosResponse.get(0).getPrecoTotal());

        assertEquals(2, listaPedidosResponse.get(1).getId());
        assertEquals("Produto 2", listaPedidosResponse.get(1).getProduto().getNome());
        assertEquals("Cliente 2", listaPedidosResponse.get(1).getCliente());
        assertEquals(2, listaPedidosResponse.get(1).getQuantidade());
        assertEquals(BigDecimal.valueOf(40.0), listaPedidosResponse.get(1).getPrecoTotal());
    }

    @Test
    void pegarPorIdPedidoEncontrado() {
        Integer idPedido = 1;
        Pedido pedido = new Pedido(idPedido, new Produto(1, "Produto 1", 1, BigDecimal.valueOf(10.0)), "Cliente 1", 1, BigDecimal.valueOf(10.0));

        when(pedidoRepository.findById(idPedido)).thenReturn(Optional.of(pedido));

        Pedido pedidoRetornado = pedidoService.pegarPorId(idPedido);

        assertNotNull(pedidoRetornado);
        assertEquals(idPedido, pedidoRetornado.getId());

        verify(pedidoRepository, times(1)).findById(idPedido);
    }

    @Test
    void pegarPorIdPedidoNaoEncontrado() {
        Integer idPedido = 1;

        when(pedidoRepository.findById(idPedido)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> pedidoService.pegarPorId(idPedido));

        verify(pedidoRepository, times(1)).findById(idPedido);
    }
}