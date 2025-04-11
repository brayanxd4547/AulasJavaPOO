package com.senai.aula05_polimorfismo.exemplos.sobrecarga.produto;

public class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto() {}

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + "\n" +
                "Preço: " + preco + "\n" +
                "Quantidade: " + quantidade + "\n";
    }
}
