package com.senai.aula04_herancaD.exemplos.veiculo;

public class Main {
    public static void main(String[] args) {
        Carro carro00 = new Carro("Renault", 2015, 4);
        Moto moto00 = new Moto("Yamaha", 2017, true);

        carro00.exibirDetalhes();
        moto00.exibirDetalhes();
    }
}
