package com.senai.aula05_polimorfismo.exercicios.ex04_sistema_de_monitoramento_de_sensores;

public class Sensor {
    protected double valor;

    public Sensor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void exibirInformacoes() {
        System.out.println("Exibição da grandeza.");
    }
}
