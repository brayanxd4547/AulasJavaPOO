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

    public String exibirInformacoes(){
        return "Nome do aluno: " + this.nome + '\n' +
               "Idade: " + this.idade + '\n' +
               "Nota: " + this.nota + '\n';
    }

    public static void atualizaNota(){

    }

    public static boolean verificarAprovacao(float nota){
        return nota >= 6;
    }

    @Override
    public String toString() {
        return "Nome do aluno: " + nome + '\n' +
               "Idade: " + idade + '\n' +
               "Nota: " + nota + '\n';
    }




}
