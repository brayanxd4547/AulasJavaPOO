package com.senai.aula05_polimorfismo.exercicios.ex04_sistema_de_monitoramento_de_sensores;

public class SensorTemperatura extends Sensor {
    public SensorTemperatura(double valor) {
        super(valor);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                 | Temperatura: %f°C
                """, valor);
    }
}
