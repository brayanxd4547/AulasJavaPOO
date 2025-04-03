package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.veiculo;

public class Moto extends Veiculo {
    public Moto(int velocidade) {
        super(velocidade);
    }

    @Override
    void ligar() {
        System.out.println("A moto ligou.");
    }
}
