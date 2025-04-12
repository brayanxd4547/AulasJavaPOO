package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static List<String> listaTiposDeRelatorios = new ArrayList<>(List.of("JSON", "PDF", "CSV"));
    static List<Relatorio> listaDeRelatorios = new ArrayList<>(List.of(
            new RelatorioPDF("Gestão de vendas - Escalario", 30),
            new RelatorioJSON("Expansão da malha ferroviária - ViaMobilidade", 120),
            new RelatorioCSV("PENDÊNCIAS - Neorume ltda",  20)
    ));

    static public String[] atributosPadraoRelatorio = {"Titulo", "Quantidade de páginas"};
    static int qtdRelatoriosSelecionados;

    public static void main(String[] args) {
        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    gerarRelatorios();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarRelatorios();
                    break;

                case 3:
                    atualizarInfoRelatorio();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerRelatorio();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarRelatorio();
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
                ║                         CONTROLE DE RELATÓRIOS                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Gerar novos relatorios                                     ║
                ║  2  ║   Listar todos os relatorios                                 ║
                ║  3  ║   Atualizar informações de um relatorio                      ║
                ║  4  ║   Remover um relatorio                                       ║
                ║  5  ║   Buscar informações de um relatorio                         ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void gerarRelatorios() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         GERAR NOVOS RELATÓRIOS                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║           Insira o tipo de relatorio que deseja gerar.             ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaTiposDeRelatorios.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDeRelatorios.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDeRelatorios.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int tipoSelecionado = scanner.nextInt() - 1;
        while (tipoSelecionado >= listaTiposDeRelatorios.size() || tipoSelecionado < 0) {
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                        GERAR NOVOS RELATÓRIOS                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║          Insira as seguintes informações sobre o relatorio:        ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos relatorios: ");
        qtdRelatoriosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdRelatoriosSelecionados; i++) {
            System.out.println("\nDigite as seguintes informações sobre o relatorio.");
            String[] atributosNovoRelatorio = new String[atributosPadraoRelatorio.length];
            for (int j = 0; j < atributosPadraoRelatorio.length; j++) {
                System.out.print(atributosPadraoRelatorio[j] + ": ");
                atributosNovoRelatorio[j] = scanner.nextLine();
            }

            listaDeRelatorios.add(new RelatorioJSON(atributosNovoRelatorio[0], Integer.parseInt(atributosNovoRelatorio[1])));
            listaDeRelatorios.getLast().gerar();
        }
    }

    public static void listarRelatorios() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         LISTAR RELATÓRIOS                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                 Segue a lista de todos os relatorios.              ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeRelatorios.forEach(relatorio -> {
            System.out.print("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while (true) {
            System.out.print("\nDigite o índice do relatorio na lista para verificar suas informações específicas ou não digite nada para voltar ao início.\n>> ");
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeRelatorios.size()) {
                    listaDeRelatorios.get(indiceFuncEscolhido).exibirInformacoes();
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

    public static void atualizarInfoRelatorio() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                          ATUALIZAR RELATÓRIOS                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais relatorios para atualizar as suas        ║
                ║      informações.                                                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeRelatorios.forEach(relatorio -> {
            System.out.print("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de relatorios a terem o custo de suas informações alteradas: ");
        qtdRelatoriosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdRelatoriosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do relatorio na lista: ");
                int indice = scanner.nextInt() - 1;
                if (indice < listaDeRelatorios.size()) {
                    scanner.nextLine();

                    System.out.println("\nDigite as seguintes informações sobre o relatorio.");
                    String[] atributosNovoRelatorio = new String[atributosPadraoRelatorio.length];
                    for (int j = 0; j < atributosPadraoRelatorio.length; j++) {
                        System.out.print(atributosPadraoRelatorio[j] + ": ");
                        atributosNovoRelatorio[j] = scanner.nextLine();
                    }

                    switch (listaDeRelatorios.get(indice).tipo) {
                        case "pdf":
                            listaDeRelatorios.set(indice, new RelatorioPDF(atributosNovoRelatorio[0], Integer.parseInt(atributosNovoRelatorio[1])));
                            break;

                        case "json":
                            listaDeRelatorios.set(indice, new RelatorioJSON(atributosNovoRelatorio[0], Integer.parseInt(atributosNovoRelatorio[1])));
                            break;

                        case "csv":
                            listaDeRelatorios.set(indice, new RelatorioCSV(atributosNovoRelatorio[0], Integer.parseInt(atributosNovoRelatorio[1])));
                            break;
                    }
                    opcaoInvalida = false;
                } else {
                    System.out.println("Relatorio inválido. Tente novamente.");
                }
            }
        }

        System.out.println("\nRelatorios altualizados!");
    }

    public static void removerRelatorio() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           REMOVER RELATÓRIOS                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║       Selecione um ou mais relatorios para serem removidos.        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeRelatorios.forEach(relatorio -> {
            System.out.print("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de relatorios a serem removidos: ");
        qtdRelatoriosSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdRelatoriosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do relatorio na lista: ");
                int indice = scanner.nextInt() - 1; scanner.nextLine();
                if (indice < listaDeRelatorios.size()) {
                    listaDeRelatorios.get(indice).setTitulo(null);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Relatorio inválido. Tente novamente.");
                }
            }
        }

        listaDeRelatorios.removeIf(f -> f.getTitulo() == null);

        System.out.println("Relatorios removidos!");
    }

    public static void buscarRelatorio() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           BUSCAR UM RELATÓRIO                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║     Selecione o título do relatorio ou seu índice para buscar      ║
                ║     suas informações.                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeRelatorios.forEach(relatorio -> {
            System.out.print("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeRelatorios.indexOf(relatorio) + 1) + "  ║  Titulo: " + (relatorio.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © UltimateText, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");

        boolean opcaoInvalida = true;
        while (opcaoInvalida) {
            String entradaRelatorioEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaRelatorioEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeRelatorios.size()) {
                    listaDeRelatorios.get(indiceFuncEscolhido).exibirInformacoes();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaRelatorioEscolhido.isEmpty()) {
                    listaDeRelatorios.stream().filter(f -> f.getTitulo().equalsIgnoreCase(entradaRelatorioEscolhido)).forEach(Relatorio::exibirInformacoes);
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
