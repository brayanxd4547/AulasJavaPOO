package com.senai.aula04_heranca.exercicios.ex05_sistema_de_bibliotecas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static List<String> listaTiposDeLivros = new ArrayList<>(List.of("Fisico", "Digital"));
    static List<Livro> listaDeLivros = new ArrayList<>(List.of(
            new LivroDigital("A Coisa do Amor", "Renan de Vasconcelos", 30),
            new LivroFisico("Contos de Uma Maçã", "Gil Costa Carvalho", 120),
            new LivroDigital("A Psicologia por Trás dos Passos", "Um Quadrado", 20)
    ));

    static public String[] atributosPadraoLivro = {"Titulo", "Autor"};
    static int qtdLivrosSelecionados;

    public static void main(String[] args) {
        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarLivros();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarLivros();
                    break;

                case 3:
                    atualizarInfoLivro();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerLivro();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarLivro();
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
                ║                         CONTROLE DE LIVROS                         ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novos livros                                     ║
                ║  2  ║   Listar todos os livros                                     ║
                ║  3  ║   Atualizar informações de um livro                          ║
                ║  4  ║   Remover um livro                                           ║
                ║  5  ║   Buscar informações de um livro                             ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarLivros() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                        ADICIONAR NOVOS LIVROS                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║    Insira o tipo de livro que deseja adicionar.                    ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaTiposDeLivros.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDeLivros.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDeLivros.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int tipoSelecionado = scanner.nextInt() - 1;
        while (tipoSelecionado >= listaTiposDeLivros.size() || tipoSelecionado < 0) {
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                        ADICIONAR NOVOS LIVROS                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║            Insira as seguintes informações sobre o livro:          ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos livros: ");
        qtdLivrosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdLivrosSelecionados; i++) {
            System.out.println("\nDigite as seguintes informações sobre o livro.");
            String[] atributosNovoLivro = new String[atributosPadraoLivro.length];
            for (int j = 0; j < atributosPadraoLivro.length; j++) {
                System.out.print(atributosPadraoLivro[j] + ": ");
                atributosNovoLivro[j] = scanner.nextLine();
            }

            switch (tipoSelecionado) {
                case 0:
                    System.out.print("Número de páginas: ");
                    int numPags = scanner.nextInt(); scanner.nextLine();

                    listaDeLivros.add(new LivroFisico(atributosNovoLivro[0], atributosNovoLivro[1], numPags));
                    break;

                case 1:
                    System.out.print("Tamanho (em MB): ");
                    float tamanho = scanner.nextFloat();

                    listaDeLivros.add(new LivroDigital(atributosNovoLivro[0], atributosNovoLivro[1], tamanho));
                    break;
            }

            System.out.println("\nLivro adicionado com sucesso!");
        }
    }

    public static void listarLivros() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                             LISTAR LIVROS                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                 Segue a lista de todos os livros.                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeLivros.forEach(livro -> {
            System.out.print("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO"));
            for (int i = 0; i < 69 - ("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while (true) {
            System.out.print("\nDigite o índice do livro na lista para verificar suas informações específicas ou não digite nada para voltar ao início.\n>> ");
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeLivros.size()) {
                    listaDeLivros.get(indiceFuncEscolhido).exibirInformacoes();
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaFuncEscolhido.isEmpty()) {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                } else {
                    break;
                }
            }
        }
    }

    public static void atualizarInfoLivro() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           ATUALIZAR LIVROS                         ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais livros para atualizar as suas            ║
                ║      informações.                                                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeLivros.forEach(livro -> {
            System.out.print("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO"));
            for (int i = 0; i < 69 - ("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de livros a terem o custo de suas informações alteradas: ");
        qtdLivrosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdLivrosSelecionados; i++) {



            boolean opcaoInvalida = true;
            while (opcaoInvalida) {




                System.out.print("\n(" + (i + 1) + ")\nÍndice do livro na lista: ");
                int indice = scanner.nextInt() - 1;
                if (indice < listaDeLivros.size()) {
                    scanner.nextLine();

                    System.out.println("\nDigite as seguintes informações sobre o livro.");
                    String[] atributosNovoLivro = new String[atributosPadraoLivro.length];
                    for (int j = 0; j < atributosPadraoLivro.length; j++) {
                        System.out.print(atributosPadraoLivro[j] + ": ");
                        atributosNovoLivro[j] = scanner.nextLine();
                    }

                    listaDeLivros.set(indice, listaDeLivros.get(indice).digital ? new LivroDigital(atributosNovoLivro[0], atributosNovoLivro[1], ((LivroDigital) listaDeLivros.get(indice)).getTamanho()) : new LivroFisico(atributosNovoLivro[0], atributosNovoLivro[1], ((LivroFisico) listaDeLivros.get(indice)).getNumPags()));
                    opcaoInvalida = false;
                } else {
                    System.out.println("Livro inválido. Tente novamente.");
                }
            }
        }

        System.out.println("\nLivros altualizados!");
    }

    public static void removerLivro() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           REMOVER LIVROS                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║       Selecione um ou mais livros para serem removidos.            ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeLivros.forEach(livro -> {
            System.out.print("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO"));
            for (int i = 0; i < 69 - ("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de livros a serem removidos: ");
        qtdLivrosSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdLivrosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do livro na lista: ");
                int indice = scanner.nextInt() - 1; scanner.nextLine();
                if (indice < listaDeLivros.size()) {
                    listaDeLivros.get(indice).setTitulo(null);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Livro inválido. Tente novamente.");
                }
            }
        }

        listaDeLivros.removeIf(f -> f.getTitulo() == null);

        System.out.println("Livros removidos!");
    }

    public static void buscarLivro() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           BUSCAR UM LIVRO                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║     Selecione o título do livro ou seu índice para buscar          ║
                ║     suas informações.                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeLivros.forEach(livro -> {
            System.out.print("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO"));
            for (int i = 0; i < 69 - ("║  " + (listaDeLivros.indexOf(livro) + 1) + "  ║  Titulo: " + (livro.getTitulo()) + (livro.digital ? " | DIGITAL" : " | FISICO")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                         © Lifegraph, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");

        boolean opcaoInvalida = true;
        while (opcaoInvalida) {
            String entradaLivroEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaLivroEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeLivros.size()) {
                    listaDeLivros.get(indiceFuncEscolhido).exibirInformacoes();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaLivroEscolhido.isEmpty()) {
                    listaDeLivros.stream().filter(f -> f.getTitulo().equalsIgnoreCase(entradaLivroEscolhido)).forEach(Livro::exibirInformacoes);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            }
        }
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
