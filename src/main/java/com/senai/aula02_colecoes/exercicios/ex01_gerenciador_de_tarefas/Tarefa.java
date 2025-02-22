package com.senai.aula02_colecoes.exercicios.ex01_gerenciador_de_tarefas;

public class Tarefa {
    String nome;
    boolean concluido;

    public Tarefa(String nome, boolean concluido) {
        this.nome = nome;
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        return  "Tarefa: " + nome + "  |  Concluído? " + (concluido ? "Sim" : "Não");
    }
}
