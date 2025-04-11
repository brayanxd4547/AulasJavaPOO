package com.senai.aula04_heranca.exercicios.ex01_controle_de_estoque;

public class Produto {
    protected String nome;
    protected double preco;
    protected String marca;

    public Produto(String nome, double preco, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Nome do sensor: %s
                 | Preço: %,.2f
                 | Marca: %s
                """, nome, preco, marca);
    }
}
