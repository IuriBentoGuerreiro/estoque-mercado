package com.iuri.estoquemercado.service;

import com.iuri.estoquemercado.dto.ProdutoEstoqueFilter;
import com.iuri.estoquemercado.dto.ProdutoRequest;
import com.iuri.estoquemercado.dto.ProdutoResponse;
import com.iuri.estoquemercado.model.Produto;
import com.iuri.estoquemercado.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(ProdutoRequest produtoRequest){
        return produtoRepository.save(Produto.converter(produtoRequest));
    }

    public Produto pegarPorId(Integer id){
        return produtoRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Recurso não encontrado")
        );
    }

    public List<ProdutoResponse> listar(){
        return produtoRepository.findAll().stream().map(
                ProdutoResponse::converter).toList();
    }

    public Produto atualizar(Integer id, ProdutoRequest produtoRequest){
        Produto produtoSalvo = pegarPorId(id);
        BeanUtils.copyProperties(produtoRequest, produtoSalvo, "id");
        return produtoRepository.save(produtoSalvo);
    }

    public void deletar(Integer id){
        produtoRepository.deleteById(id);
    }

    public ProdutoResponse atualizarEstoque(Integer id, ProdutoEstoqueFilter filter){
       var produto = pegarPorId(id);
       var quantidadeAtualizada = produto.getQuantidadeEstoque() + filter.getQuantidadeEstoque();
       produto.setQuantidadeEstoque(quantidadeAtualizada);
       BeanUtils.copyProperties(produto, filter, "id", "nome", "preco");
       produtoRepository.save(produto);
       return ProdutoResponse.converter(produto);
    }
}