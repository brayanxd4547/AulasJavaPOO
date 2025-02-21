package com.senai.aula03_encapsulamento.exercicios.ex02_conta_bancaria_com_operacoes_simples;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contaBancaria00 = new ContaBancaria("Umberto Jr.", 10000);

        System.out.println("Titular da conta bancária: " + contaBancaria00.getTitular());
        System.out.printf("Saldo da conta bancária: R$%,.2f\n",  contaBancaria00.getSaldo());

        contaBancaria00.setTitular("Doisberto Jr.");
        contaBancaria00.setSaldo(20000);

        System.out.println("Titular da conta bancária: " + contaBancaria00.getTitular());
        System.out.printf("Saldo da conta bancária: R$%,.2f\n",  contaBancaria00.getSaldo());

        contaBancaria00.depositar(1000);
        contaBancaria00.sacar(5000);
    }
}
