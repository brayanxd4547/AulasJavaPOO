package com.senai.aula04_heranca.exercicios.ex05_sistema_de_bibliotecas;

public class Main {
    public static void main(String[] args) {
        System.out.println("Informações do livro 1");
        testarLivro(new LivroDigital("A mensagem do nada", "Bruno Leonardo Camões", 12));

        System.out.println("Informações do livro 2");
        testarLivro(new LivroFisico("Perspectiva alternativa", "Berenice Lima Cruz", 283));
    }

    public static void testarLivro(Livro livro){
        livro.exibirInformacoes();
    }
}
