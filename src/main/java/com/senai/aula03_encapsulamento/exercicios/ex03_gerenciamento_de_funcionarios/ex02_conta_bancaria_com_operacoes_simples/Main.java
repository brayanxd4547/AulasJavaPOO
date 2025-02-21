package com.senai.aula03_encapsulamento.exercicios.ex03_gerenciamento_de_funcionarios.ex02_conta_bancaria_com_operacoes_simples;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario00 = new Funcionario("Umberto Jr.", 10000);

        System.out.println("Titular da conta bancária: " + funcionario00.getNome());
        System.out.printf("Saldo da conta bancária: R$%,.2f\n",  funcionario00.getSalario());

        funcionario00.setNome("Doisberto Jr.");
        funcionario00.setSalario(20000);

        System.out.println("Titular da conta bancária: " + funcionario00.getNome());
        System.out.printf("Saldo da conta bancária: R$%,.2f\n",  funcionario00.getSalario());

        funcionario00.aumentarPercentual(1000);
        funcionario00.sacar(5000);
    }
}
