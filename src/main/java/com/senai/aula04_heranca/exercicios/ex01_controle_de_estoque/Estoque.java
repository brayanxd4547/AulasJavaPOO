package com.senai.aula04_heranca.exercicios.ex01_controle_de_estoque;

public class Estoque {
    private String produto;
    private int quantidade;

    public Estoque(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirInformacoes(){
        System.out.println("Produto: " + produto + "  |  Quantidade: " + quantidade);
    }
}
