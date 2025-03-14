package com.senai.aula04_heranca.exercicios.ex01_controle_de_estoque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static ArrayList<String> tiposDeProdutos = new ArrayList<>(Arrays.asList("Alimento", "Eletrônico"));

    static ArrayList<Estoque> listaDeEstoques = new ArrayList<>();

    static public String[] atributosProduto = {"nome", "preço", "marca"};

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
/*
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
                    break;*/
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
                ║     Insira o tipo do produto do estoque que deseja adicionar.      ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        tiposDeProdutos.forEach(tipo -> {
            System.out.print("║  " + (tiposDeProdutos.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + tiposDeProdutos.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        String tipoSelecionado = tiposDeProdutos.get(scanner.nextInt() - 1);

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS ESTOQUES                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║     Insira as seguintes informações sobre os novos estoques:       ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos estoques: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdEstoquesSelecionados; i++) {

            for (int j = 0; j < atributosProduto.length; j++) {
                //TODO: Termina isso aqui
            }

            System.out.println("\nEstoque " + (i + 1) + ":");

            System.out.println("Insira o nome do produto desse estoque: ");
            String nome = scanner.nextLine().toLowerCase();

            System.out.println("Insira o preço do produto desse estoque: ");
            String preco = scanner.nextLine().toLowerCase();

            System.out.println("Insira o preço do produto desse estoque: ");
            String marca = scanner.nextLine().toLowerCase();

            System.out.print("Insira a quantidade de " + nome + " nesse estoque: ");
            listaDeEstoques.add(new Estoque(nome, scanner.nextInt()));
            scanner.nextLine();
        }

        System.out.println("\nEstoques adicionados!");
    }
/*
    public static void listarEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           LISTAR ESTOQUES                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Segue a lista de todos os estoques de produtos.            ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        tiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (tiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto() + " | Quantidade: " + estoque.getQuantidade());
            for (int i = 0; i < 69 - ("║  " + tiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto() + " | Quantidade: " + estoque.getQuantidade()).length(); i++) {
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
        tiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (tiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto() + " | Quantidade: " + estoque.getQuantidade());
            for (int i = 0; i < 69 - ("║  " + tiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto() + " | Quantidade: " + estoque.getQuantidade()).length(); i++) {
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
            System.out.print("Nova quantidade de " + tiposDeProdutos.get(indice).getProduto() + " no estoque: ");
            tiposDeProdutos.get(indice).setQuantidade(scanner.nextInt());
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
        tiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (tiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto());
            for (int i = 0; i < 69 - ("║  " + tiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto()).length(); i++) {
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
            tiposDeProdutos.get(scanner.nextInt() - 1).setProduto(null);
            scanner.nextLine();
        }

        // Intenção: usar o laço 'for-each' para remover cada elemento dada uma condição
        // Recomendação do IntelliJ: usar 'removeIf' em vez do laço 'for-each'
        tiposDeProdutos.removeIf(estoque -> estoque.getProduto() == null);

        System.out.println("Estoques removidos!");
    }

    public static void buscarEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         BUSCAR UM ESTOQUE                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione o nome do produto de um estoque para             ║
                ║         buscar suas informações.                                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        tiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (tiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto());
            for (int i = 0; i < 69 - ("║  " + tiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto()).length(); i++) {
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
        tiposDeProdutos.stream().filter(estoque -> estoque.getProduto().equals(produtoEscolhido)).forEach(System.out::println);
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
    }*/
        
        
        /*Alimento alimento00 = new Alimento("salgadinho", 10, "Doritos", "14/12/2025");
        alimento00.exibirInformacoes();
        System.out.println("_________________________________________________");

        Eletronico eletronico00 = new Eletronico("ventilador", 300, "Mondeal", 110, 2);
        eletronico00.exibirInformacoes();
        System.out.println("_________________________________________________");*/
}