package com.senai.aula02_colecoes.exercicios.ex02_controle_de_estoque_de_produtos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static ArrayList<Estoque> listaEstoques = new ArrayList<>();
    static int qtdEstoquesSelecionados;

    public static void main(String[] args) {
        do {
            mostrarMenu();
            switch (opcao) {
                case 1:
                    adicionarEstoques();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarEstoques();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    atualizarQtdProdutos();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerEstoques();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarEstoque();
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
                ║                  CONTROLE DE ESTOQUE DE PRODUTOS                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novos estoques de produtos                       ║
                ║  2  ║   Listar todos os estoques                                   ║
                ║  3  ║   Atualizar quantidade de produtos em um estoque             ║
                ║  4  ║   Remover um estoque de produtos                             ║
                ║  5  ║   Buscar informações de um estoque pelo nome do produto      ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarEstoques() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS ESTOQUES                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║     Insira a quantidade de estoques que deseja adicionar, o        ║
                ║     produto de cada estoque e as suas quantidades.                 ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos estoques: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdEstoquesSelecionados; i++) {
            System.out.print("\n(" + (i + 1) + ")" + "\nInsira o produto do estoque: ");
            String produto = scanner.nextLine().toLowerCase();
            System.out.print("Insira a quantidade de " + produto + " no estoque: ");
            listaEstoques.add(new Estoque(produto, scanner.nextInt()));
            scanner.nextLine();
        }

        System.out.println("\nEstoques adicionados!");
    }

    public static void listarEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           LISTAR ESTOQUES                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Segue a lista de todos os estoques de produtos.            ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.produto + " | Quantidade: " + estoque.quantidade);
            for (int i = 0; i < 69 - ("║  " + listaEstoques.indexOf(estoque) + "  ║  " + estoque.produto + " | Quantidade: " + estoque.quantidade).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
    }

    public static void atualizarQtdProdutos() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║           ATUALIZAR QUANTIDADE DE PRODUTOS NOS ESTOQUES            ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais estoques para atualizar a sua            ║
                ║      quantidade de produtos.                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.produto + " | Quantidade: " + estoque.quantidade);
            for (int i = 0; i < 69 - ("║  " + listaEstoques.indexOf(estoque) + "  ║  " + estoque.produto + " | Quantidade: " + estoque.quantidade).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de estoques a terem sua quantidade de produtos alterada: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdEstoquesSelecionados; i++) {
            System.out.print("\n(" + (i + 1) + ")\nÍndice do estoque na lista: ");
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();
            System.out.print("Nova quantidade de " + listaEstoques.get(indice).produto + " no estoque: ");
            listaEstoques.get(indice).quantidade = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("\nEstoques alterados!");
    }

    public static void removerEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         REMOVER ESTOQUES                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione um ou mais estoques para serem removidos.        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.produto);
            for (int i = 0; i < 69 - ("║  " + listaEstoques.indexOf(estoque) + "  ║  " + estoque.produto).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de estoques a serem removidos: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdEstoquesSelecionados; i++) {
            System.out.print("\n(" + (i + 1) + ")\nÍndice do estoque na lista: ");
            listaEstoques.get(scanner.nextInt() - 1).produto = null;
            scanner.nextLine();
        }

        // Intenção: usar o laço 'for-each' para remover cada elemento dada uma condição
        // Recomendação do IntelliJ: usar 'removeIf' em vez do laço 'for-each'
        listaEstoques.removeIf(estoque -> estoque.produto == null);

        System.out.println("Estoques removidos!");
    }

    public static void buscarEstoque(){
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         BUSCAR UM ESTOQUE                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione o nome do produto de um estoque para             ║
                ║         buscar suas informações.                                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.produto);
            for (int i = 0; i < 69 - ("║  " + listaEstoques.indexOf(estoque) + "  ║  " + estoque.produto).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        String produtoEscolhido = scanner.nextLine().toLowerCase();
        listaEstoques.stream().filter(estoque -> estoque.produto.equals(produtoEscolhido)).forEach(System.out::println);
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