package com.senai.aula06_abstracao.exercicios.ex02_controle_de_entrega;

public abstract class VeiculoEntrega {
    protected float velocidadeAtual;
    protected float distanciaDestino;
    protected float capacidadeDeCarga;
    protected String cliente;
    protected float custo;

    public VeiculoEntrega(float velocidadeAtual, float distanciaDestino, float capacidadeDeCarga, String cliente, float custo) {
        this.velocidadeAtual = velocidadeAtual;
        this.distanciaDestino = distanciaDestino;
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.cliente = cliente;
        this.custo = custo;
    }

    public float getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public float getDistanciaDestino() {
        return distanciaDestino;
    }

    public abstract void exibirInfoVeiculo();
    public abstract void calcularEstimativaEntrega();
    public abstract void verificarVelMax();

    public void exibirInfoPedido() {
        System.out.println("Detalhes do pedido:");
        System.out.printf("""
                 | Nome do cliente: %s
                 | Custo: R$%,.2f
                 | Distância do pedido: %.1fm
                """, cliente, custo, distanciaDestino);
    }

    public void aumentarVelocidade(float acrescimo){
        velocidadeAtual += acrescimo;
        System.out.printf("Velocidade aumentada para %.1fkm/h\n", velocidadeAtual);
        verificarVelMax();
    }
}
