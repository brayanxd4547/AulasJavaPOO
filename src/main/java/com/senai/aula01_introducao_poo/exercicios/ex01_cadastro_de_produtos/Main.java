package com.senai.aula01_introducao_poo.exercicios.ex01_cadastro_de_produtos;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static Produto[] matrizProdutos = new Produto[0];
    static int produtoSelecionado;

    static String[] atributosProduto = {"nome", "preço", "quantidade"};

    public static void main(String[] args) {
        do {
            mostrarMenu();
            switch (opcao) {
                case 1:
                    crieNovoEstoque();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    exibaEstoque();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    atualizeEstoque();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    calculeValoresTotais();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    encerrePrograma();
                    break;
            }
        } while (!sair);
    }

    public static void mostrarMenu() {
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
    }

    public static void crieNovoEstoque() {
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

            novaMatrizProdutos[i] = new Produto(dadosProduto[0], Float.parseFloat(dadosProduto[1]), Integer.parseInt(dadosProduto[2]));

            System.out.println("______________________________\n");
        }

        matrizProdutos = novaMatrizProdutos;

        System.out.println("Novos estoques registrados com sucesso!\n");
        for (int i = 0; i < matrizProdutos.length; i++) {
            System.out.println(matrizProdutos[i]);
        }
    }

    public static void exibaEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                EXIBIR INFORMAÇÕES DE UM PRODUTO                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║        Selecione um produto para visualizar as informações:        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizProdutos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizProdutos[i].nome);
            for (int j = 0; j < 59 - matrizProdutos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝                    
                """);

        produtoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println(matrizProdutos[produtoSelecionado]);
    }

    public static void atualizeEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                ATUALIZAR O ESTOQUE DE UM PRODUTO                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║          Selecione um produto para atualizar as quantidade:        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizProdutos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizProdutos[i].nome);
            for (int j = 0; j < 59 - matrizProdutos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝                    
                """);

        produtoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        String input;
        do {
            System.out.println("Você deseja acrescentar ou remover uma quantidade do estoque? (A para acrescentar / R para remover)");
            input = scanner.nextLine();
        } while(!(input.equalsIgnoreCase("a") || input.equalsIgnoreCase("r")));

        boolean escolha = input.equalsIgnoreCase("a");

        System.out.println("Quantos produtos você deseja " + (escolha ? "acrescentar " : "remover ") + "do estoque?");
        matrizProdutos[produtoSelecionado].atualizaEstoque(escolha, scanner.nextInt());
        scanner.nextLine();

        System.out.println(matrizProdutos[produtoSelecionado]);
    }

    public static void calculeValoresTotais() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║         TABELA DOS VALORES TOTAIS DOS ESTOQUES DOS PRODUTOS        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizProdutos.length; i++) {
            float valorTotal = matrizProdutos[i].preco * matrizProdutos[i].quantidade;
            System.out.printf("║  " + (i + 1) + "  ║   " + matrizProdutos[i].nome + ": R$%,.2f", valorTotal);
            for (int j = 0; j < 53 - (matrizProdutos[i].nome.length() + String.valueOf(valorTotal).length()); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝                    
                """);
    }

    public static void encerrePrograma() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                                                                    ║
                ║                           Fim do programa.                         ║
                ║                                                                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        sair = true;
    }
}