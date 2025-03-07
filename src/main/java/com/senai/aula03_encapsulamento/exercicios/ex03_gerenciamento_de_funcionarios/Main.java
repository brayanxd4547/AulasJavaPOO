package com.senai.aula03_encapsulamento.exercicios.ex03_gerenciamento_de_funcionarios;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario00 = new Funcionario("Zé Roberto", 10000, 1);

        System.out.println("Nome do funcionário: " + funcionario00.getNome());
        System.out.printf("Salário: R$%,.2f\n",  funcionario00.getSalario());
        System.out.println("Cargo: " + funcionario00.getCargo());
        System.out.println();

        funcionario00.setNome("Menusumberto");
        funcionario00.setSalario(5000);
        funcionario00.setCargo(66);

        System.out.println("Nome do funcionário: " + funcionario00.getNome());
        System.out.printf("Salário: R$%,.2f\n",  funcionario00.getSalario());
        System.out.println("Cargo: " + funcionario00.getCargo());
        System.out.println();

        funcionario00.aumentarPercentual(50);
    }
}