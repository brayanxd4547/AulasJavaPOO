package com.senai.aula03_encapsulamento.exercicios.ex01_cadastro_de_produto_simples;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        if (preco >= 0){
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
    }

    // Getters e setters

    // Nome
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    // Preço
    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        if (preco >= 0){
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return  "Nome do produto: " + nome + "\n" +
                "Preço: " + preco;
    }
}
