package com.senai.aula04_heranca.exercicios.ex01_controle_de_estoque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static ArrayList<String> listaTiposDeProdutos = new ArrayList<>(Arrays.asList("Alimento", "Eletrônico"));
    static ArrayList<Estoque> listaDeEstoques = new ArrayList<>();

    static public String[] atributosPadraoProduto = {"Nome", "Preço", "Marca"};
    static int qtdEstoquesSelecionados;

    public static void main(String[] args) {
        listaDeEstoques.add(new Estoque(new Alimento("maçã", 3, "pomera", "23-04-2025"), 1000));
        listaDeEstoques.add(new Estoque(new Alimento("banana", 3, "ananasia", "23-04-2025"), 1000));

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
/*
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
        listaTiposDeProdutos.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDeProdutos.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDeProdutos.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
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
        int tipoProdutoSelecionado = scanner.nextInt() - 1;
        while (tipoProdutoSelecionado >= listaTiposDeProdutos.size() || tipoProdutoSelecionado < 0){
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoProdutoSelecionado = scanner.nextInt() - 1;
        }

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
            System.out.println("\nDigite as seguintes informações sobre o produto.");
            String[] atributosNovoProduto = new String[3];
            for (int j = 0; j < atributosPadraoProduto.length; j++) {
                System.out.print(atributosPadraoProduto[j] + ": ");
                atributosNovoProduto[j] = scanner.nextLine().toLowerCase();
            }

            switch (tipoProdutoSelecionado) {
                case 0:
                    System.out.print("Data de validade: ");
                    String dataValidade = scanner.nextLine();

                    System.out.print("Quantidade do produto nesse estoque: ");

                    listaDeEstoques.add(new Estoque(new Alimento(atributosNovoProduto[0], Float.parseFloat(atributosNovoProduto[1]), atributosNovoProduto[2], dataValidade), scanner.nextInt()));
                    break;
                case 1:
                    System.out.print("Tensão elétrica: ");
                    float tensaoEletrica = scanner.nextFloat();

                    System.out.print("Corrente elétrica: ");
                    float correnteEletrica = scanner.nextFloat();

                    System.out.print("Quantidade do produto nesse estoque: ");

                    listaDeEstoques.add(new Estoque(new Eletronico(atributosNovoProduto[0], Float.parseFloat(atributosNovoProduto[1]), atributosNovoProduto[2], tensaoEletrica, correnteEletrica), scanner.nextInt()));
                    break;
            }
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

        listaDeEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + (estoque.getProduto().getNome()) + " (marca " + estoque.getProduto().getMarca() + ") | Quantidade: " + estoque.getQuantidade());
            for (int i = 0; i < 69 - ("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + (estoque.getProduto().getNome()) + " (marca " + estoque.getProduto().getMarca() + ") | Quantidade: " + estoque.getQuantidade()).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while(true){
            System.out.print("\nDigite o índice do produto na lista para verificar suas informações específicas ou digite I para voltar ao início.\n>> ");
            String opcaoInformacoes = scanner.nextLine();
            try {
                listaDeEstoques.get(Integer.parseInt(opcaoInformacoes)).getProduto().exibirInformacoes();
            } catch (NumberFormatException e){
                if (!opcaoInformacoes.equalsIgnoreCase("I")){
                    System.out.println("Esta opção não é válida. Tente novamente.");
                } else {
                    break;
                }
            }
        }
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
        listaTiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (listaTiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto() + " | Quantidade: " + estoque.getQuantidade());
            for (int i = 0; i < 69 - ("║  " + listaTiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto() + " | Quantidade: " + estoque.getQuantidade()).length(); i++) {
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
            System.out.print("Nova quantidade de " + listaTiposDeProdutos.get(indice).getProduto() + " no estoque: ");
            listaTiposDeProdutos.get(indice).setQuantidade(scanner.nextInt());
            scanner.nextLine();
        }

        System.out.println("\nEstoques alterados!");
    }

    /*
    public static void removerEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         REMOVER ESTOQUES                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione um ou mais estoques para serem removidos.        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaTiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (listaTiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto());
            for (int i = 0; i < 69 - ("║  " + listaTiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto()).length(); i++) {
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
            listaTiposDeProdutos.get(scanner.nextInt() - 1).setProduto(null);
            scanner.nextLine();
        }

        // Intenção: usar o laço 'for-each' para remover cada elemento dada uma condição
        // Recomendação do IntelliJ: usar 'removeIf' em vez do laço 'for-each'
        listaTiposDeProdutos.removeIf(estoque -> estoque.getProduto() == null);

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
        listaTiposDeProdutos.forEach(estoque -> {
            System.out.print("║  " + (listaTiposDeProdutos.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto());
            for (int i = 0; i < 69 - ("║  " + listaTiposDeProdutos.indexOf(estoque) + "  ║  " + estoque.getProduto()).length(); i++) {
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
        listaTiposDeProdutos.stream().filter(estoque -> estoque.getProduto().equals(produtoEscolhido)).forEach(System.out::println);
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