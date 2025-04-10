package com.senai.aula04_herancaD.exercicios.ex03_sistema_de_gestao_de_pedidos;

import java.util.List;

public class PedidoPresencial extends Pedido{
    private double descontoVista;

    public PedidoPresencial(String cliente, double valorOriginal, List<String> componentes, double descontoVista) {
        super(cliente, valorOriginal, componentes);
        this.descontoVista = descontoVista;
    }

    public double getDescontoVista() {
        return descontoVista;
    }

    public void setDescontoVista(double taxaEntrega) {
        this.descontoVista = taxaEntrega;
    }

    @Override
    public double calcularValorTotal() {
        return this.getValorOriginal() - descontoVista;
    }
}
