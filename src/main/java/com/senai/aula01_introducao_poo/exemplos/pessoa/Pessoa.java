package com.senai.aula01_introducao_poo.exemplos.pessoa;

public class Pessoa {
    // Atributos
    String nome;
    int idade;
    float altura;
    Endereco endereco; // Este atributo é um outro objeto

    // Construtor: cria o objeto e obriga a inserção de atributos no Main
    public Pessoa(String nome, int idade, float altura, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.endereco = endereco;
    }

    // Criar um segundo construtor permite escolher quais parâmetros são obrigatórios
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos
    public void falar(String frase) {
        System.out.println(nome + " disse: " + frase);
    }

    public void comer(String alimento) {
        System.out.println(nome + " comeu " + alimento + ".");
    }

    // toString: converte os dados para texto
    @Override // Indica que o método em questão é deste objeto, e não do raíz (chamado Object)
    public String toString() {
        return "Nome da pessoa: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Altura: " + altura + "\n" +
                "Endereço:\n" + endereco + "\n" ;
    }
}
