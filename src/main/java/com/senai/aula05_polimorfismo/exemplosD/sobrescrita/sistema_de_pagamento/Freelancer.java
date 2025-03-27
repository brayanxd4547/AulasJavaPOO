package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.sistema_de_pagamento;

public class Freelancer extends Pagamento {
    private double valorProjeto;

    public Freelancer(String nome, double valorProjeto) {
        super(nome);
        this.valorProjeto = valorProjeto;
    }

    @Override
    public double calcularPagamento() {
        return valorProjeto;
    }
}
