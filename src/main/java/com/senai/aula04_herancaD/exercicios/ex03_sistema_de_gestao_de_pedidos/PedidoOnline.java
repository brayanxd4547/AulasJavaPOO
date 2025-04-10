package com.senai.aula04_herancaD.exercicios.ex03_sistema_de_gestao_de_pedidos;

import java.util.List;

public class PedidoOnline extends Pedido{
    private double taxaEntrega;

    public PedidoOnline(String cliente, double valorOriginal, List<String> componentes, double taxaEntrega) {
        super(cliente, valorOriginal, componentes);
        this.taxaEntrega = taxaEntrega;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    @Override
    public double calcularValorTotal() {
        return this.getValorOriginal() + taxaEntrega;
    }
}
