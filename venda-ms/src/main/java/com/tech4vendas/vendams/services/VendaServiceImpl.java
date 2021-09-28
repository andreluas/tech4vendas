package com.tech4vendas.vendams.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4vendas.vendams.model.Venda;
import com.tech4vendas.vendams.repository.VendaRepository;
import com.tech4vendas.vendams.shared.Produto;
import com.tech4vendas.vendams.shared.VendaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repositorio;

    @Override
    public List<VendaDto> obterVendas() {
        List<Venda> vendas = repositorio.findAll();
        return vendas.stream().map(v -> new ModelMapper().map(v, VendaDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> venda = repositorio.findById(id);

        if (venda.isPresent()) {
            return Optional.of(new ModelMapper().map(venda.get(), VendaDto.class));
        }

        return Optional.empty();
    }

    @Override
    public VendaDto novaVenda(VendaDto venda) {
        Venda salvarVenda = new ModelMapper().map(venda, Venda.class);
        salvarVenda = repositorio.save(salvarVenda);
        return new ModelMapper().map(salvarVenda, VendaDto.class);
    }

    @Override
    public void deletarVenda(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<VendaDto> editarVenda(String id, VendaDto venda) {
        Optional<Venda> vend = repositorio.findById(id);
        Venda salvarVenda = new ModelMapper().map(venda, Venda.class);

        if (vend.isPresent()) {
            salvarVenda.setId(id);
            salvarVenda = repositorio.save(salvarVenda);
            return Optional.of(new ModelMapper().map(salvarVenda, VendaDto.class));
        }

        return Optional.empty();
    }

    @Override
    public List<VendaDto> obterPorProduto(Produto produto) {
        List<Venda> vendas = repositorio.findByProduto(produto);

        return vendas.stream()
            .map(p -> new ModelMapper().map(produto, VendaDto.class))
            .collect(Collectors.toList());
    }
}
