package com.senai.aula04_herancaD.exercicios.ex03_sistema_de_gestao_de_pedidos;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new PedidoPresencial("Romário", 50, new ArrayList<>(Arrays.asList("batata frita", "hambúrguer", "refrigerante")), 10);
        Pedido pedido2 = new PedidoOnline("Carlo", 60, new ArrayList<>(Arrays.asList("batata frita", "hambúrguer", "refrigerante", "sundae de chocolate")), 6.66);

        System.out.println("Valor total do pedido " + pedido1.getNumPedido() + ": " + pedido1.calcularValorTotal());
        System.out.println("Valor total do pedido " + pedido2.getNumPedido() + ": " + pedido2.calcularValorTotal());
    }
}
