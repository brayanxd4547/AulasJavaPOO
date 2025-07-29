package com.senai.aula08_clean_code.aula01_ex01_novo;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcaoMenu;
    static boolean programaExecutando = true;

    static Produto[] matrizProdutos = {
            new Produto("Macarrão", 15f, 1200),
            new Produto("Sopa de tomate", 10f, 1400),
    };
    static int produtoSelecionado;

    public static void main(String[] args) {
        do {
            mostrarMenu();
            switch (opcaoMenu) {
                case 1 -> crieNovoEstoque();
                case 2 -> exibaEstoque();
                case 3 -> atualizeEstoque();
                case 4 -> calculeValoresTotais();
                case 5 -> removerEstoque();
                case 6 -> encerrePrograma();
                default -> System.out.println("Opção inválida.");
            }
        } while (programaExecutando);
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
                ║  5  ║   Remover um estoque                                         ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcaoMenu = scanner.nextInt();
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

        System.arraycopy(matrizProdutos, 0, novaMatrizProdutos, 0, matrizProdutos.length);

        for (int i = matrizProdutos.length; i < novaMatrizProdutos.length; i++) {
            String[] dadosProduto = new String[3];

            System.out.print("Nome do produto: ");
            dadosProduto[0] = scanner.nextLine();

            System.out.print("Preço do produto em reais: ");
            dadosProduto[1] = scanner.nextLine();

            System.out.print("Quantidade do produto no estoque: ");
            dadosProduto[2] = scanner.nextLine();

            novaMatrizProdutos[i] = new Produto(dadosProduto[0], Float.parseFloat(dadosProduto[1]), Integer.parseInt(dadosProduto[2]));

            System.out.println("______________________________\n");
        }

        matrizProdutos = novaMatrizProdutos;
        System.out.println("Novos estoques registrados com sucesso!\n");

        System.out.println("Digite qualquer tecla para continuar...");
        scanner.nextLine();
    }

    private static void exibirListaEstoques() {
        System.out.println("""
                ║                        Selecione um produto:                       ║
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

        produtoSelecionado = scanner.nextInt() - 1; // Corrige o índice selecionado começando por 0, não 1
        scanner.nextLine();
    }

    public static void exibaEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                EXIBIR INFORMAÇÕES DE UM PRODUTO                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        exibirListaEstoques();

        matrizProdutos[produtoSelecionado].exibirDetalhes();

        System.out.println("Digite qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public static void atualizeEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                ATUALIZAR O ESTOQUE DE UM PRODUTO                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        exibirListaEstoques();

        String input;
        do {
            System.out.println("Você deseja acrescentar ou remover uma quantidade do estoque? (A para acrescentar / R para remover)");
            input = scanner.nextLine();
        } while (!(input.equalsIgnoreCase("a") || input.equalsIgnoreCase("r")));

        boolean escolha = input.equalsIgnoreCase("a");

        System.out.println("Quantos produtos você deseja " + (escolha ? "acrescentar " : "remover ") + "do estoque?");
        matrizProdutos[produtoSelecionado].atualizaEstoque(escolha, scanner.nextInt());
        scanner.nextLine();

        System.out.println(matrizProdutos[produtoSelecionado]);

        System.out.println("Digite qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public static void calculeValoresTotais() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║         TABELA DOS VALORES TOTAIS DOS ESTOQUES DOS PRODUTOS        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        for (int i = 0; i < matrizProdutos.length; i++) {
            System.out.printf("║  " + (i + 1) + "  ║   " + matrizProdutos[i].nome + ": R$%,.2f\n", matrizProdutos[i].calcularValorEstoque());
        }
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                  ©Lopes Supermercados, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        System.out.println("Digite qualquer tecla para continuar...");
    }

    public static void removerEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                    REMOVER UM ESTOQUE DE PRODUTOS                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        exibirListaEstoques();

        Produto[] novaMatrizProdutos = new Produto[matrizProdutos.length - 1];

        int i = 0;
        for (int j = 0; j < matrizProdutos.length; j++) {
            if (produtoSelecionado != j) {
                novaMatrizProdutos[i] = matrizProdutos[j];
                i++;
            }
        }

        matrizProdutos = novaMatrizProdutos;

        System.out.println("Estoque removido com sucesso!\n");
        for (Produto produto : matrizProdutos) {
            System.out.println(produto);
        }

        System.out.println("Digite qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public static void encerrePrograma() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                                                                    ║
                ║                           Fim do programa.                         ║
                ║                                                                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        programaExecutando = false;
    }
}