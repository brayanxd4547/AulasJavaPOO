package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.conta_bancaria;

public class Main {
    public static void main(String[] args) {
       testarConta(new ContaCorrente("Marilúcio júnior", 30000));
    }

    private static void testarConta(ContaBancaria conta) {
        System.out.printf(" - Testando conta do cliente %s - \n", conta.titular);
        conta.exibirSaldo();
        conta.aplicarTaxaMensal();
        conta.exibirSaldo();
    }
}
