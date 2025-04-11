package com.senai.aula04_heranca.exercicios.ex03_sistema_de_gestao_de_pedidos;

import java.util.List;
import java.util.Random;

public class Pedido {
    private String cliente;
    private final int numPedido;
    private double valorOriginal;
    private List<String> componentes;
    protected final boolean online;

    public Pedido(String cliente, double valorOriginal, List<String> componentes, boolean online) {
        this.cliente = cliente;
        this.numPedido = new Random().nextInt(1000000);
        this.valorOriginal = valorOriginal;
        this.componentes = componentes;
        this.online = online;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public List<String> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<String> componentes) {
        this.componentes = componentes;
    }

    public double calcularValorTotal() {
        return valorOriginal;
    }

    public boolean isOnline() {
        return online;
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Cliente: %s
                 | Valor original: R$%,.2f
                 | Número do pedido: %d
                 | Componentes:
                """, cliente, valorOriginal, numPedido);
        componentes.forEach(c -> System.out.print(c + ", "));
    }
}
