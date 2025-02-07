package com.senai.aula01_introducao_poo.exercicios.ex01_cadastro_de_produtos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] matrizProdutos = new Produto[0];
        int opcao;
        do {
            System.out.println("""
                    ╔════════════════════════════════════════════════════════════════════╗
                    ║                               MENU                                 ║
                    ╠════════════════════════════════════════════════════════════════════╣
                    ║  Selecione uma opção:                                              ║
                    ╠════════════════════════════════════════════════════════════════════╣
                    ║  1  ║   Criar novos estoques de produtos                           ║
                    ║  2  ║   Exibir informações de um produto                           ║
                    ║  3  ║   Atualizar o estoque de um produto                          ║
                    ║  4  ║   Calcular o valor total do estoque de um produto            ║
                    ║  5  ║   Sair                                                       ║
                    ╠════════════════════════════════════════════════════════════════════╣
                    ║                  © Lopes Supermercados, 2025                       ║
                    ╚════════════════════════════════════════════════════════════════════╝                    
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("""
                            ╔════════════════════════════════════════════════════════════════════╗
                            ║                 CRIAR NOVOS ESTOQUES DE PRODUTOS                   ║
                            ╠════════════════════════════════════════════════════════════════════╣
                            ║                                                                    ║
                            ║     Insira a quantidade de novos estoques que deseja registrar     ║
                            ║     e os dados do estoque do produto a ser criado.                 ║
                            ║                                                                    ║
                            ╠════════════════════════════════════════════════════════════════════╣
                            ║                  © Lopes Supermercados, 2025                       ║
                            ╚════════════════════════════════════════════════════════════════════╝                    
                            """);

                    int qtdNovosProdutos = scanner.nextInt();
                    scanner.nextLine();
                    Produto[] novaMatrizProdutos = new Produto[qtdNovosProdutos + matrizProdutos.length];

                    for (int i = 0; i < matrizProdutos.length; i++) {
                        novaMatrizProdutos[i] = matrizProdutos[i];
                    }

                    for (int i = matrizProdutos.length; i < qtdNovosProdutos; i++) {
                        String[] dadosProduto = new String[3];

                        System.out.println("Nome do produto: ");
                        dadosProduto[0] = scanner.nextLine();

                        System.out.println("Preço do produto em reais: ");
                        dadosProduto[1] = scanner.nextLine();

                        System.out.println("Quantidade do produto no estoque: ");
                        dadosProduto[2] = scanner.nextLine();

                        novaMatrizProdutos[i] = new Produto(dadosProduto[0],Float.parseFloat(dadosProduto[1]),Integer.parseInt(dadosProduto[2]));

                        System.out.println("______________________________\n");
                    }

                    matrizProdutos = novaMatrizProdutos;
                    break;
                case 2:
                    System.out.println("""
                            ╔════════════════════════════════════════════════════════════════════╗
                            ║                EXIBIR INFORMAÇÕES DE UM PRODUTO                    ║
                            ╠════════════════════════════════════════════════════════════════════╣
                            ║        Selecione um produto para visualizar as informações:        ║
                            ║                                                                    ║
                            """);
                    /*║1  ║Nome                                                       ║
                    ║2  ║Nome                                                       ║
                    ║3  ║Nome                                                       ║*/
                    System.out.println("""
                            ╠════════════════════════════════════════════════════════════════════╣
                            ║                  © Lopes Supermercados, 2025                       ║
                            ╚════════════════════════════════════════════════════════════════════╝                    
                            """);
                    break;
                case 3:
                    System.out.println("""
                            ╔════════════════════════════════════════════════════════════════════╗
                            ║                ATUALIZAR O ESTOQUE DE UM PRODUTO                   ║
                            ╠════════════════════════════════════════════════════════════════════╣
                            """);
                    /*║1  ║Nome                                                       ║
                    ║2  ║Nome                                                       ║
                    ║3  ║Nome                                                       ║*/
                    System.out.println("""
                            ╠════════════════════════════════════════════════════════════════════╣
                            ║                  © Lopes Supermercados, 2025                       ║
                            ╚════════════════════════════════════════════════════════════════════╝                    
                            """);
                    break;
                case 4:
                    System.out.println("""
                            ╔════════════════════════════════════════════════════════════════════╗
                            ║         TABELA DOS VALORES TOTAIS DOS ESTOQUES DOS PRODUTOS        ║
                            ╠════════════════════════════════════════════════════════════════════╣
                            """);
                    /*║1  ║Nome   ║R$340, 00                                        ║
                    ║2  ║Nome   ║R$340, 00                                        ║
                    ║3  ║Nome   ║R$340, 00                                        ║*/
                    System.out.println("""
                            ╠════════════════════════════════════════════════════════════════════╣
                            ║                  © Lopes Supermercados, 2025                       ║
                            ╚════════════════════════════════════════════════════════════════════╝                    
                            """);
                    break;
                case 5:
                    System.out.println("""
                            ╔════════════════════════════════════════════════════════════════════╗
                            ║                                                                    ║
                            ║                           Fim do programa.                         ║
                            ║                                                                    ║
                            ╚════════════════════════════════════════════════════════════════════╝
                            """);
                    break;
            }
        } while (true);
    }
}
