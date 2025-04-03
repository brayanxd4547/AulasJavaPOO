package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.veiculo;

public class Main {
    public static void main(String[] args) {
        testarAnimal(new Carro(30));
        testarAnimal(new Moto(40));
    }

    public static void testarAnimal(Veiculo veiculo){
        veiculo.ligar();
        veiculo.acelerar(10);
        veiculo.acelerar(20);
    }
}
