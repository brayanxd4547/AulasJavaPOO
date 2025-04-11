package com.senai.aula04_heranca.exemplos.gerenciamento_de_contas_bancarias;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente00 = new ContaCorrente("Miguel Carlos", 3000, 200);
        ContaPoupanca contaPoupanca00 = new ContaPoupanca("Fernando Cardoso", 3000, 5);

        contaPoupanca00.sacar(3200);
        contaCorrente00.sacar(3200);
        System.out.println("________________________________________________________________________________________________________________________");

        contaPoupanca00.aplicarRendimento();
        contaPoupanca00.setTaxaDeRendimento(20);
        contaPoupanca00.aplicarRendimento();
        System.out.println("________________________________________________________________________________________________________________________");

        contaCorrente00.depositar(10000);
        contaCorrente00.transferir(1000, contaPoupanca00);
        System.out.println("________________________________________________________________________________________________________________________");

        contaPoupanca00.exibirSaldo();
        System.out.println();

        contaCorrente00.exibirSaldo();
        System.out.println();
    }
}
