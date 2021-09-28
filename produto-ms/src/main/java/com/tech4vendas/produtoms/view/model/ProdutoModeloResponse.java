package com.tech4vendas.produtoms.view.model;

public class ProdutoModeloResponse {
    private String id;
    private Integer codigo;
    private String nome;
    private Double valor;
    private Integer qtdEstoque;

    // #region
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getProdutoDesc() {
        return String.format("%d - %s - R$%.2f - Estoque: %d", codigo, nome, valor, qtdEstoque);
    }
}
