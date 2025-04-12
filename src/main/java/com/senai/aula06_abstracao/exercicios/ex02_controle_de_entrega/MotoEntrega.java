package com.senai.aula06_abstracao.exercicios.ex02_controle_de_entrega;

public class MotoEntrega extends VeiculoEntrega {
    public MotoEntrega(float velocidadeAtual, float distanciaDestino, float capacidadeDeCarga, String cliente, float custo) {
        super(velocidadeAtual, distanciaDestino, capacidadeDeCarga, cliente, custo);
    }

    @Override
    public void exibirInfoVeiculo() {
        System.out.println("Detalhes da moto de entrega:");
        System.out.printf("""
                 | Velocidade atual: %.1fkm/h
                 | Capacidade de carga: %.1fkg
                """, velocidadeAtual, capacidadeDeCarga);
    }

    @Override
    public void calcularEstimativaEntrega() {
        float estimativa = (distanciaDestino / (velocidadeAtual / 3.6f)) / 60 + 5;
        System.out.printf("O tempo de entrega estimado é de %.0f minuto%s (Foram acrescentados 5 minutos por conta de trânsito).\n", estimativa, estimativa > 1 ? "s" : "");
    }

    @Override
    public void verificarVelMax() {
        System.out.println("MOTOCICLETA LIVRE DE LIMITE MÁXIMO.");
    }
}
