package com.senai.aula04_herancaD.exercicios.ex03_sistema_de_gestao_de_pedidos;

import java.util.List;
import java.util.Random;

public class Pedido {
    private String cliente;
    private final int numPedido;
    private double valorOriginal;
    private List<String> componentes;

    public Pedido(String cliente, double valorOriginal, List<String> componentes) {
        this.cliente = cliente;
        this.numPedido = new Random().nextInt(1000000);
        this.valorOriginal = valorOriginal;
        this.componentes = componentes;
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
