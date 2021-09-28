package com.tech4vendas.produtoms.services;

import java.util.List;
import java.util.Optional;

import com.tech4vendas.produtoms.shared.ProdutoDto;

public interface ProdutoService {
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorId(String id);
    ProdutoDto criarProduto(ProdutoDto produto);
    void deletarProduto(String id);
    Optional<ProdutoDto> editarProduto(String id, ProdutoDto produto);
}




