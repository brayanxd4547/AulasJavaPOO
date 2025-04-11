package com.senai.aula04_herancaD.exercicios.ex04_sistema_de_atendimento_medico;

public class Paciente {
    private String nome;
    private int idade;
    private double custoConsulta;

    public Paciente(String nome, int idade, double custoConsulta) {
        this.nome = nome;
        this.idade = idade;
        this.custoConsulta = custoConsulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getCustoConsulta() {
        return custoConsulta;
    }

    public void setCustoConsulta(double custoConsulta) {
        this.custoConsulta = custoConsulta;
    }

    public Double calcularValorTotal(){
        return custoConsulta;
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Nome do paciente: %s
                 | Idade: %d
                 | Custo original da consulta: R$%,.2f
                """, nome, idade, custoConsulta);
    }
}
