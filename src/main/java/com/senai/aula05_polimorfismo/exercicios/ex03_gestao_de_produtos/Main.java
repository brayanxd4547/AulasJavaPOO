package com.senai.aula05_polimorfismo.exercicios.ex03_gestao_de_produtos;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste do produto físico");
        testarProduto(new ProdutoFisico("João", 300, 30));

        System.out.println("Teste do produto digital");
        testarProduto(new ProdutoDigital("Marta", 300, 20));

        System.out.println("Teste do produto de serviço");
        testarProduto(new ProdutoServico("Carlos", 300, 15));
    }

    public static void testarProduto(Produto produto){
        produto.exibirInformacoes();
    }
}
