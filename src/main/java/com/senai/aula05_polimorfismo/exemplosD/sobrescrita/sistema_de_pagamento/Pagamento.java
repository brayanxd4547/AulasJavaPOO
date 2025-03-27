package com.senai.aula05_polimorfismo.exemplosD.sobrescrita.sistema_de_pagamento;

public class Pagamento {
    private String nome;

    public Pagamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double calcularPagamento(){
        return 0;
    }
}
