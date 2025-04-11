package com.senai.aula04_heranca.exercicios.ex02_sistema_de_funcionarios;

public class Professor extends Funcionario {
    private String disciplina;

    public Professor(String nome, double salario, String disciplina) {
        super(nome, salario);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Disciplina: %s
                """, disciplina);
    }
}
