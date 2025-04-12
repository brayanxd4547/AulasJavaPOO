package com.senai.aula05_polimorfismo.exercicios.ex05_sistema_de_beneficios_de_funcionarios;

public class Beneficio {
    protected double desconto;

    public Beneficio(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void exibirInformacoes() {
        System.out.println("Exibição do benefício.");
    }
}
