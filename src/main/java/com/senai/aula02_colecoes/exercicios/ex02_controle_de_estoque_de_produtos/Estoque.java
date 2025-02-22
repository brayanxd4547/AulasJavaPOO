package com.senai.aula02_colecoes.exercicios.ex02_controle_de_estoque_de_produtos;

public class Estoque {
    String produto;
    int quantidade;

    public Estoque(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return  "Produto: " + produto + "  |  Quantidade: " + quantidade;
    }
}
