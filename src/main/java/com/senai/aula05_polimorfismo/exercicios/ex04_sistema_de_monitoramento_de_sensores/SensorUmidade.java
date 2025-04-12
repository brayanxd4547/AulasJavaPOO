package com.senai.aula05_polimorfismo.exercicios.ex04_sistema_de_monitoramento_de_sensores;

public class SensorUmidade extends Sensor {
    public SensorUmidade(double valor) {
        super(valor);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                 | Umidade: %.1f%%
                """, valor);
    }
}
