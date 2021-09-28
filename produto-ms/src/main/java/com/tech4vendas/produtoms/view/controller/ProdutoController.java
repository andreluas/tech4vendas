package com.tech4vendas.produtoms.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tech4vendas.produtoms.services.ProdutoService;
import com.tech4vendas.produtoms.shared.ProdutoDto;
import com.tech4vendas.produtoms.view.model.ProdutoModeloRequest;
import com.tech4vendas.produtoms.view.model.ProdutoModeloResponse;

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
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService servico;

    @GetMapping("/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e sendo executado na porta %s", porta);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos() {
        List<ProdutoDto> dtos = servico.obterTodos();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<ProdutoModeloResponse> response = dtos.stream()
                .map(dto -> new ModelMapper().map(dto, ProdutoModeloResponse.class)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModeloResponse> obterPorId(@PathVariable String id) {
        Optional<ProdutoDto> produto = servico.obterPorId(id);

        if (produto.isPresent()) {
            return new ResponseEntity<>(new ModelMapper().map(produto.get(), ProdutoModeloResponse.class),
                    HttpStatus.OK);
        }

        return new ResponseEntity<ProdutoModeloResponse>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProdutoModeloResponse> criarProduto(@RequestBody @Valid ProdutoModeloRequest produto) {
        ProdutoDto dto = new ModelMapper().map(produto, ProdutoDto.class);
        dto = servico.criarProduto(dto);
        return new ResponseEntity<>(new ModelMapper().map(dto, ProdutoModeloResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        servico.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModeloResponse> editarProduto(@PathVariable String id, @RequestBody @Valid ProdutoModeloRequest produto) {
        ProdutoDto dto = new ModelMapper().map(produto, ProdutoDto.class);
        Optional<ProdutoDto> prod = servico.editarProduto(id, dto);

        if (prod.isPresent()){
            return new ResponseEntity<>(new ModelMapper().map(prod.get(), ProdutoModeloResponse.class), HttpStatus.OK);
        }
        

        return new ResponseEntity<ProdutoModeloResponse>(HttpStatus.NOT_FOUND);
    }
}