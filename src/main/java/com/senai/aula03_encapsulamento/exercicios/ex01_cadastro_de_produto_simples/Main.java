package com.senai.aula03_encapsulamento.exercicios.ex01_cadastro_de_produto_simples;

public class Main {
    public static void main(String[] args) {
        Produto produto00 = new Produto("Sopa de tomate", 10);

        System.out.println("Nome do produto: " + produto00.getNome());
        System.out.printf("Preço do produto: R$%,.2f\n", produto00.getPreco());
        System.out.println();

        produto00.setNome("Sopa de frango");
        produto00.setPreco(20);

        System.out.println("Nome do produto: " + produto00.getNome());
        System.out.printf("Preço do produto: R$%,.2f\n", produto00.getPreco());
        System.out.println();
    }
}
