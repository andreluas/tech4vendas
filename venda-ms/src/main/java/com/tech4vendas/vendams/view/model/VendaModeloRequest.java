package com.tech4vendas.vendams.view.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class VendaModeloRequest {
    @NotNull(message = "Produto deve ser inserido")
    private String produto;
    @NotNull(message = "Quantidade da venda deve ser preenchida")
    private Integer qtdVendida;
    @NotNull(message = "Valor da venda deve ser preenchido")
    private Double valorTotal;
    @NotNull(message = "Data da venda deve ser preenchido")
    private LocalDate data;

    // #region
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

   
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    // #endregion
}