package com.tech4vendas.produtoms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4vendas.produtoms.model.Produto;
import com.tech4vendas.produtoms.repository.ProdutoRepository;
import com.tech4vendas.produtoms.shared.ProdutoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        Produto salvarProduto = new ModelMapper().map(produto, Produto.class);
        salvarProduto = repositorio.save(salvarProduto);
        return new ModelMapper().map(salvarProduto, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repositorio.findAll();
        return produtos.stream().map(p -> new ModelMapper().map(p, ProdutoDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repositorio.findById(id);

        if (produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void deletarProduto(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<ProdutoDto> editarProduto(String id, ProdutoDto produto) {
        Optional<Produto> prod = repositorio.findById(id);
        Produto salvarProduto = new ModelMapper().map(produto, Produto.class);

        if (prod.isPresent()) {
            salvarProduto.setId(id);
            salvarProduto = repositorio.save(salvarProduto);
            return Optional.of(new ModelMapper().map(salvarProduto, ProdutoDto.class));
        }

        return Optional.empty();
    }
}