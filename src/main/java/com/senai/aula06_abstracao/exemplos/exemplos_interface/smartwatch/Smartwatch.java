package com.senai.aula06_abstracao.exemplos.exemplos_interface.smartwatch;

public class Smartwatch implements SensorCardiaco, SensorPassos, SensorSono{
    @Override
    public void medirFrequenciaCardiaca() {
        System.out.println("Medição cardíaca: 80bpm");
    }

    @Override
    public void contarPassos() {
        System.out.println("Passos hoje: 3000 passoe");
    }

    @Override
    public void medirQualidadeDeSono() {
        System.out.println("Qualidade de sono: 7h30 de sono profundo.");
    }

    public void feedbackDispositivos() {
        System.out.println("Dispositivos conectados...");
    }
}
