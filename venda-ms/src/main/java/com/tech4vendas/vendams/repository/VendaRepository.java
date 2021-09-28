package com.tech4vendas.vendams.repository;

import java.util.List;

import com.tech4vendas.vendams.model.Venda;
import com.tech4vendas.vendams.shared.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String>{
 
    List<Venda> findByProduto(Produto produto);
}