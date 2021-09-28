package com.tech4vendas.vendams.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tech4vendas.vendams.services.VendaService;
import com.tech4vendas.vendams.shared.Produto;
import com.tech4vendas.vendams.shared.VendaDto;
import com.tech4vendas.vendams.view.model.VendaModeloRequest;
import com.tech4vendas.vendams.view.model.VendaModeloResponse;
import com.tech4vendas.vendams.view.model.VendaModeloResponseDetalhes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService servico;

    @GetMapping("/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e sendo executado na porta %s", porta);
    }

    @GetMapping
    public ResponseEntity<List<VendaModeloResponse>> obterVendas() {
        List<VendaDto> dtos = servico.obterVendas();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<VendaModeloResponse> response = dtos.stream()
                .map(dto -> new ModelMapper().map(dto, VendaModeloResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaModeloResponseDetalhes> obterPorId(@PathVariable String id) {
        Optional<VendaDto> venda = servico.obterPorId(id);

        if (venda.isPresent()) {
            return new ResponseEntity<>(new ModelMapper().map(venda.get(), VendaModeloResponseDetalhes.class), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VendaModeloResponse> novaVenda(@RequestBody @Valid VendaModeloRequest venda) {
        VendaDto dto = new ModelMapper().map(venda, VendaDto.class);
        dto = servico.novaVenda(dto);
        return new ResponseEntity<>(new ModelMapper().map(dto, VendaModeloResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable String id) {
        servico.deletarVenda(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaModeloResponse> editarVenda(@PathVariable String id, @RequestBody @Valid VendaModeloRequest venda) {
        VendaDto dto = new ModelMapper().map(venda, VendaDto.class);
        Optional<VendaDto> vend = servico.editarVenda(id, dto);

        if(vend.isPresent()) {
            return new ResponseEntity<>(new ModelMapper().map(vend.get(), VendaModeloResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<VendaModeloResponse>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{produto}/lista")
    public ResponseEntity<List<VendaModeloResponse>> obterPorVenda(@PathVariable Produto produto) {
        List<VendaDto> dtos = servico.obterPorProduto(produto);

        if(dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<VendaModeloResponse> response = dtos.stream()
            .map(dto -> new ModelMapper().map(dto, VendaModeloResponse.class))
            .collect(Collectors.toList());
            
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
