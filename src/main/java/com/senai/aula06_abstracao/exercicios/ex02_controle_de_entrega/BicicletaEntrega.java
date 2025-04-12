package com.senai.aula06_abstracao.exercicios.ex02_controle_de_entrega;

public class BicicletaEntrega extends VeiculoEntrega {
    protected final float velocidadeMaxima = 60;

    public BicicletaEntrega(float velocidadeAtual, float distanciaDestino, float capacidadeDeCarga, String cliente, float custo) {
        super(velocidadeAtual, distanciaDestino, capacidadeDeCarga, cliente, custo);
    }

    @Override
    public void verificarVelMax(){
        if (velocidadeAtual > velocidadeMaxima){
            velocidadeAtual = velocidadeMaxima;
            System.out.printf("VELOCIDADE MÁXIMA ATINGIDA PARA BICICLETA: %.1fkm/h\n", velocidadeMaxima);
        }
    }

    @Override
    public void exibirInfoVeiculo() {
        System.out.println("Detalhes da bicicleta de entrega:");
        System.out.printf("""
                 | Velocidade atual: %.1fkm/h
                 | Capacidade de carga: %.1fkg
                 | Velocidade máxima: %.1fkm/h
                """, velocidadeAtual, capacidadeDeCarga, velocidadeMaxima);
    }

    @Override
    public void calcularEstimativaEntrega() {
        float estimativa = (distanciaDestino / (velocidadeAtual / 3.6f)) / 60;
        System.out.printf("O tempo de entrega estimado é de %.0f minuto%s.\n", estimativa, estimativa > 1 ? "s" : "");
    }
}
