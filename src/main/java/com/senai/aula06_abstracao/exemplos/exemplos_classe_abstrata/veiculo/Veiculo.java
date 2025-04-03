package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.veiculo;

public abstract class Veiculo {
    protected int velocidade;

    public Veiculo(int velocidade) {
        this.velocidade = 0;
    }

    public void acelerar(int incremento){
        velocidade += incremento;
        System.out.println("Acelerando para " + velocidade + "km/h.");
    }

    abstract void ligar();
}
