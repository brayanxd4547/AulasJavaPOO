package com.senai.aula05_polimorfismo.exemplos.sobrescrita.gestao_de_veiculos;

public class Main {
    public static void main(String[] args) {
        realizarManutencao(new Carro("Civic"));
        realizarManutencao(new Moto("Factor"));
        realizarManutencao(new Carro("Scania"));
    }

    private static void realizarManutencao(Veiculo veiculo){
        veiculo.realizarManutencao();
    }
}
