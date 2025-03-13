package com.senai.aula04_heranca.exemplos.sistema_de_cadastro_de_funcionarios;

public class Funcionario {
    private String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Getter e setter de nome

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter de salario

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void exibirInformacoes(){
        System.out.printf("Nome do funcionário: %s\nSalário: R$%,.2f\n", nome, salario);
    }
}
