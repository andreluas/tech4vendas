package com.tech4vendas.vendams.view.model;

import java.time.LocalDate;

public class VendaModeloResponse {
    private String id;
    private String produto;
    private Integer qtdVendida;
    private Double valorTotal;
    private LocalDate data;

    // #region
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
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
    // #endregion
}