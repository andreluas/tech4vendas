package com.tech4vendas.vendams.services;

import java.util.List;
import java.util.Optional;

import com.tech4vendas.vendams.shared.Produto;
import com.tech4vendas.vendams.shared.VendaDto;

public interface VendaService {
    List<VendaDto> obterVendas();
    Optional<VendaDto> obterPorId(String id);
    VendaDto novaVenda(VendaDto venda);
    void deletarVenda(String id);
    Optional<VendaDto> editarVenda(String id, VendaDto venda);
    List<VendaDto> obterPorProduto(Produto produto);
}
