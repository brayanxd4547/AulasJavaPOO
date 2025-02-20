package com.senai.aula01_introducao_poo.exercicios.ex02_gerenciamento_de_alunos;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static Aluno[] matrizAlunos = {
            new Aluno("Roberto Fonseca", 10, 8.3f),
            new Aluno("Carlos Drummond", 15, 6.2f),
            new Aluno("Inácio Pereira", 17, 9)
    };
    static int alunoSelecionado;

    //todo BORA TRABALHAR

    public static void main(String[] args) {
        do {
            mostrarMenu();
            switch (opcao) {
                case 1:
                    registreNovoAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    exibirInformacoesDeAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    atualizeAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    verifiqueAprovacaoDeAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    apagueAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 6:
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

    public static void registreNovoAluno() {
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
        Aluno[] novaMatrizProdutos = new Aluno[qtdNovosProdutos + matrizAlunos.length];

        for (int i = 0; i < matrizAlunos.length; i++) {
            novaMatrizProdutos[i] = matrizAlunos[i];
        }

        for (int i = matrizAlunos.length; i < novaMatrizProdutos.length; i++) {
            String[] dadosProduto = new String[3];

            System.out.println("Nome do produto: ");
            dadosProduto[0] = scanner.nextLine();

            System.out.println("Preço do produto em reais: ");
            dadosProduto[1] = scanner.nextLine();

            System.out.println("Quantidade do produto no estoque: ");
            dadosProduto[2] = scanner.nextLine();

            novaMatrizProdutos[i] = new Aluno(dadosProduto[0], Float.parseFloat(dadosProduto[1]), Integer.parseInt(dadosProduto[2]));

            System.out.println("______________________________\n");
        }

        matrizAlunos = novaMatrizProdutos;

        System.out.println("Novos estoques registrados com sucesso!\n");
        for (Aluno produto : matrizAlunos) {
            System.out.println(produto);
        }
    }

    public static void exibirInformacoesDeAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                EXIBIR INFORMAÇÕES DE UM PRODUTO                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║        Selecione um produto para visualizar as informações:        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome);
            for (int j = 0; j < 59 - matrizAlunos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        alunoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println(matrizAlunos[alunoSelecionado]);
    }

    public static void atualizeAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                ATUALIZAR O ESTOQUE DE UM PRODUTO                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║          Selecione um produto para atualizar as quantidade:        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome);
            for (int j = 0; j < 59 - matrizAlunos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        alunoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        String input;
        do {
            System.out.println("Você deseja acrescentar ou remover uma quantidade do estoque? (A para acrescentar / R para remover)");
            input = scanner.nextLine();
        } while (!(input.equalsIgnoreCase("a") || input.equalsIgnoreCase("r")));

        boolean escolha = input.equalsIgnoreCase("a");

        System.out.println("Quantos produtos você deseja " + (escolha ? "acrescentar " : "remover ") + "do estoque?");
        matrizAlunos[alunoSelecionado].atualizaEstoque(escolha, scanner.nextInt());
        scanner.nextLine();

        System.out.println(matrizAlunos[alunoSelecionado]);
    }

    public static void verifiqueAprovacaoDeAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║         TABELA DOS VALORES TOTAIS DOS ESTOQUES DOS PRODUTOS        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.printf("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome + ": R$%,.2f\n", matrizAlunos[i].calcularValorEstoque());
        }
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                  © Lopes Supermercados, 2025                       ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
    }

    public static void apagueAluno() {

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