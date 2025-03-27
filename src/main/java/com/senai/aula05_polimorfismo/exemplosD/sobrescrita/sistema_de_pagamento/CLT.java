package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.sistema_de_pagamento;

public class CLT extends Pagamento {
    private double salario;

    public CLT(String nome, double salario) {
        super(nome);
        this.salario = salario;
    }

    @Override
    public double calcularPagamento() {
        return salario;
    }
}
