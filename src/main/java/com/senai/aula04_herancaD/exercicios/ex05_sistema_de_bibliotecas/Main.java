package com.senai.aula04_herancaD.exercicios.ex05_sistema_de_bibliotecas;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new LivroDigital("A mensagem do nada", "Bruno Leonardo Camões", 12);
        Livro livro2 = new LivroFisico("Perspectiva alternativa", "Berenice Lima Cruz", 283);

        System.out.println("Informações do livro 1");
        livro1.exibirInformacoes();

        System.out.println("Informações do livro 2");
        livro2.exibirInformacoes();
    }
}
