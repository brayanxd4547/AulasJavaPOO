package com.senai.aula06_abstracao.exercicios.ex02_controle_de_entrega;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao gerenciamento de pedidos da DeliveryExpress.");

        VeiculoEntrega pedido1 = new BicicletaEntrega(10, 750, 30, "Mario Vasconcelos", 120);
        VeiculoEntrega pedido2 = new MotoEntrega(60, 3200, 90, "Pedro Silva Lopes", 110);

        System.out.println("\nTeste do pedido 1");
        testarPedido(pedido1);

        System.out.println("\nTeste do pedido 2");
        testarPedido(pedido2);
    }

    public static void testarPedido(VeiculoEntrega veiculo){
        veiculo.exibirInfoPedido();
        veiculo.exibirInfoVeiculo();
        veiculo.calcularEstimativaEntrega();
        veiculo.aumentarVelocidade(60);
        veiculo.calcularEstimativaEntrega();
    }
}
