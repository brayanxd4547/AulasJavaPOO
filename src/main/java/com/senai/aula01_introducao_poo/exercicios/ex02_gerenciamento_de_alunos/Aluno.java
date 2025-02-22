package com.senai.aula01_introducao_poo.exercicios.ex02_gerenciamento_de_alunos;

public class Aluno {
    String nome;
    int idade;
    float nota;

    public Aluno(String nome, int idade, float nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    public void exibirInformacoes() {
        System.out.println("Nome do aluno: " + this.nome + '\n' +
                           "Idade: " + this.idade + '\n' +
                           "Nota: " + this.nota + '\n');
    }

    public void atualizaNota(float novaNota) {
        this.nota = novaNota;
    }

    public boolean verificarAprovacao() {
        return this.nota >= 6;
    }
}
