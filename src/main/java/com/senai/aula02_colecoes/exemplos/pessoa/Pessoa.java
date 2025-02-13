package com.senai.aula02_colecoes.exemplos.pessoa;

public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void falar(String frase) {
        System.out.println(nome + " disse: " + frase);
    }

    public void comer(String alimento) {
        System.out.println(nome + " comeu " + alimento + ".");
    }

    @Override
    public String toString() {
        return "Nome da pessoa: " + nome + " | Idade: " + idade;
    }
}
