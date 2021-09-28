package com.tech4vendas.vendams.view.model;

import java.time.LocalDate;
import java.util.List;

import com.tech4vendas.vendams.shared.Produto;

public class VendaModeloResponseDetalhes {
    private String id;
    private List<Produto> produtos;
    private Integer qtdVendida;
    private Double valorTotal;
    private LocalDate data;

    //#region
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public Integer getQtdVendida() {
        return qtdVendida;
    }
    public void setQtdVendida(Integer qtdVendida) {
        this.qtdVendida = qtdVendida;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    //#endregion

}
