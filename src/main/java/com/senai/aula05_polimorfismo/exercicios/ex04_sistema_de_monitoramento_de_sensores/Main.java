package com.senai.aula05_polimorfismo.exercicios.ex04_sistema_de_monitoramento_de_sensores;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste do sensor de temperatura");
        testarSensor(new SensorUmidade(30));

        System.out.println("Teste do sensor de umidade");
        testarSensor(new SensorTemperatura(40.0));
    }

    public static void testarSensor(Sensor sensor){
        sensor.exibirInformacoes();
    }
}
