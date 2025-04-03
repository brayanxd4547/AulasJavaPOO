package com.senai.aula04_herancaD.exercicios.ex02_sistema_de_funcionarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static ArrayList<String> listaCargosDeFuncionarios = new ArrayList<>(Arrays.asList("Coordenador", "Professor"));
    static ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();

    static public String[] atributosPadraoFuncionario = {"Nome", "Salário"};
    static int qtdFuncionariosSelecionados;

    public static void main(String[] args) {
        Professor professor0 = new Professor("Robesvaldo", 3000, "Matemática");
        listaDeFuncionarios.add(professor0);
        Professor professor1 = new Professor("Fernandinho", 3400, "Língua Portuguesa");
        listaDeFuncionarios.add(professor1);
        Coordenador coordenador1 = new Coordenador("Edinaldo", 7000, new ArrayList<>(Arrays.asList(professor0, professor1)));
        listaDeFuncionarios.add(coordenador1);

        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarFuncionarios();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarEstoques();
                    break;/*
TODO: Terminar outras funções
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
                ║                     CONTROLE DE FUNCIONÁRIOS                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novos funcionários                               ║
                ║  2  ║   Listar todos os funcionários                               ║
                ║  3  ║   Atualizar informações de um funcionário                    ║
                ║  4  ║   Remover um funcionário                                     ║
                ║  5  ║   Buscar informações de um funcionário                       ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarFuncionarios() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                   ADICIONAR NOVOS FUNCIONÁRIOS                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║      Insira o cargo do funcionário que deseja adicionar.           ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaCargosDeFuncionarios.forEach(cargo -> {
            System.out.print("║  " + (listaCargosDeFuncionarios.indexOf(cargo) + 1) + "  ║  " + cargo);
            for (int i = 0; i < 69 - ("║  " + listaCargosDeFuncionarios.indexOf(cargo) + "  ║  " + cargo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int cargoSelecionado = scanner.nextInt() - 1;
        while (cargoSelecionado >= listaCargosDeFuncionarios.size() || cargoSelecionado < 0) {
            System.out.println("Cargo selecionado inválido. Tente novamente.");
            cargoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                   ADICIONAR NOVOS FUNCIONÁRIOS                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║      Insira as seguintes informações sobre o funcionário:          ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos funcionários: ");
        qtdFuncionariosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdFuncionariosSelecionados; i++) {
            System.out.println("\nDigite as seguintes informações sobre o funcionário.");
            String[] atributosNovoFuncionario = new String[3];
            for (int j = 0; j < atributosPadraoFuncionario.length; j++) {
                System.out.print(atributosPadraoFuncionario[j] + ": ");
                atributosNovoFuncionario[j] = scanner.nextLine();
            }

            switch (cargoSelecionado) {
                case 0:
                    System.out.print("Equipe de professores - indique a quantidade de professores: ");
                    int qtdProfessores = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<String> equipeProfessores = new ArrayList<>();
                    for (int j = 0; j < qtdProfessores; j++) {
                        System.out.print("Insira o nome do professor (" + (j + 1) + "): ");
                        equipeProfessores.add(scanner.nextLine());
                    }

                    listaDeFuncionarios.add(new Coordenador(
                            atributosNovoFuncionario[0],
                            Float.parseFloat(atributosNovoFuncionario[1]),
                            new ArrayList<>(Arrays.asList(listaDeFuncionarios.stream().filter(f -> equipeProfessores.contains(f.getNome()) && f.getCargo().equalsIgnoreCase("Professor")).toArray())))
                    );
                    break;
                case 1:
                    System.out.print("Disciplina do professor: ");
                    String disciplina = scanner.nextLine();

                    listaDeFuncionarios.add(new Professor(atributosNovoFuncionario[0], Float.parseFloat(atributosNovoFuncionario[1]), disciplina));
                    break;
            }
            scanner.nextLine();
        }

        System.out.println("\nFuncionários adicionados!");
    }

    public static void listarEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                   LISTAR FUNCIONÁRIOS                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Segue a lista de todos os funcionários.                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);

        listaDeFuncionarios.forEach(funcionario -> {
            System.out.print("║  " + (listaDeFuncionarios.indexOf(funcionario) + 1) + "  ║  " + (funcionario.getNome()) + " | Cargo: " + funcionario.getCargo());
            for (int i = 0; i < 69 - ("║  " + (listaDeFuncionarios.indexOf(funcionario) + 1) + "  ║  " + (funcionario.getNome()) + " | Cargo: " + funcionario.getCargo()).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while(true){
            System.out.print("\nDigite o índice do funcionário na lista para verificar suas informações específicas ou não digite nada para voltar ao início.\n>> ");
            String opcaoInformacoes = scanner.nextLine();
            try {
                listaDeFuncionarios.get(Integer.parseInt(opcaoInformacoes) - 1).exibirInformacoes();
            } catch (NumberFormatException e){
                if (!opcaoInformacoes.isEmpty()){
                    System.out.println("Esta opção não é válida. Tente novamente.");
                } else {
                    break;
                }
            }
        }
    }
}