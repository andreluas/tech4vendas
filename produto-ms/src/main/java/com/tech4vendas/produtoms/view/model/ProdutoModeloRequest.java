package com.tech4vendas.produtoms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoModeloRequest {
    private String venda;
    @NotNull(message = "Código não pode ser nulo")
    private Integer codigo;
    @NotEmpty(message = "Nome do produto deve ser preenchido")
    @NotBlank(message = "Nome deve possuir caracteres não brancos")
    private String nome;
    @NotNull(message = "Valor do produto não pode ser nulo")
    private Double valor;
    @NotNull(message = "Estoque do produto não pode ser nulo")
    private Integer qtdEstoque;

    // #region
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    // #endregion
}

