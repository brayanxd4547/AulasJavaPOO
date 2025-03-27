package com.senai.aula04_herancaD.exercicios.ex01_controle_de_estoque;

public class Estoque {
    private Produto produto;
    private int quantidade;

    public Estoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirInformacoes(){
        System.out.println("Informações do produto: ");
        produto.exibirInformacoes();
        System.out.println("Quantidade: " + quantidade);
    }
}
