package com.senai.aula04_herancaD.exercicios.ex02_sistema_de_funcionarios;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo(){
        String[] cargoSplit = this.getClass().toString().split("\\.");
        return cargoSplit[cargoSplit.length-1];
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Nome do funcionário: %s
                 | Salário: %,.2f
                 | Cargo: %s
                """, nome, salario, getCargo());
    }
}
