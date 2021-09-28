package com.tech4vendas.vendams.clientHTTP;

import java.util.List;

import com.tech4vendas.vendams.shared.Produto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto-ms")
public interface ProdutosFeignClient {
    @GetMapping(path = "/api/produtos/{id}")
    List<Produto> obterProdutos(@PathVariable Produto produto);
}
