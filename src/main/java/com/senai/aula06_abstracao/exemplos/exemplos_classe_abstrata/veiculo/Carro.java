package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.veiculo;

public class Carro extends Veiculo {
    public Carro(int velocidade) {
        super(velocidade);
    }

    @Override
    void ligar() {
        System.out.println("O carro ligou.");
    }
}
