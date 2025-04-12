package com.senai.aula04_heranca.exercicios.ex04_sistema_de_atendimento_medico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static List<String> listaTiposDePacientes = new ArrayList<>(List.of("Particular", "Convenio"));
    static List<Paciente> listaDePacientes = new ArrayList<>(List.of(
            new PacienteConvenio("Amanda", 23, 300, 30),
            new PacienteParticular("Breno", 32, 120),
            new PacienteConvenio("Cristiano", 45, 200, 32)
    ));

    static public String[] atributosPadraoPaciente = {"Cliente", "Valor Original", "Quantidade de consultas do paciente"};
    static int qtdPacientesSelecionados;

    public static void main(String[] args) {
        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarPacientes();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarPacientes();
                    break;

                case 3:
                    atualizarInfoPaciente();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerPaciente();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarPaciente();
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
                ║                       CONTROLE DE PACIENTES                        ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novos pacientes                                  ║
                ║  2  ║   Listar todos os pacientes                                  ║
                ║  3  ║   Atualizar consultas de um paciente                         ║
                ║  4  ║   Remover um paciente                                        ║
                ║  5  ║   Buscar informações de um paciente                          ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarPacientes() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS PACIENTES                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║    Insira o tipo da consulta do paciente que deseja adicionar.     ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaTiposDePacientes.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDePacientes.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDePacientes.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int tipoSelecionado = scanner.nextInt() - 1;
        while (tipoSelecionado >= listaTiposDePacientes.size() || tipoSelecionado < 0) {
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS PACIENTES                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║      Insira as seguintes informações sobre o paciente:             ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos pacientes: ");
        qtdPacientesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdPacientesSelecionados; i++) {
            System.out.println("\nDigite as seguintes consultas sobre o paciente.");
            String[] atributosNovoPaciente = new String[atributosPadraoPaciente.length];
            for (int j = 0; j < atributosPadraoPaciente.length; j++) {
                System.out.print(atributosPadraoPaciente[j] + ": ");
                atributosNovoPaciente[j] = scanner.nextLine();
            }

            switch (tipoSelecionado) {
                case 0:
                    listaDePacientes.add(new PacienteParticular(atributosNovoPaciente[0], Integer.parseInt(atributosNovoPaciente[1]), Double.parseDouble(atributosNovoPaciente[2])));
                    break;

                case 1:
                    System.out.print("Desconto do convênio: ");
                    double desconto = scanner.nextDouble();

                    listaDePacientes.add(new PacienteConvenio(atributosNovoPaciente[0], Integer.parseInt(atributosNovoPaciente[1]), Double.parseDouble(atributosNovoPaciente[2]), desconto));
                    break;
            }

            System.out.println("\nPaciente adicionado com sucesso!");
        }
    }

    public static void listarPacientes() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           LISTAR PACIENTES                         ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                 Segue a lista de todos os pacientes.               ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePacientes.forEach(paciente -> {
            System.out.print("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR"));
            for (int i = 0; i < 69 - ("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while (true) {
            System.out.print("\nDigite o índice do paciente na lista para verificar suas consultas específicas ou não digite nada para voltar ao início.\n>> ");
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDePacientes.size()) {
                    listaDePacientes.get(indiceFuncEscolhido).exibirInformacoes();
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

    public static void atualizarInfoPaciente() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                    ATUALIZAR CONSULTAS DE PACIENTES                ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais pacientes para atualizar as suas         ║
                ║      consultas.                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePacientes.forEach(paciente -> {
            System.out.print("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR"));
            for (int i = 0; i < 69 - ("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de pacientes a terem o custo de suas consultas alteradas: ");
        qtdPacientesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdPacientesSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do paciente na lista: ");
                int indice = scanner.nextInt() - 1;
                if (indice < listaDePacientes.size()) {
                    scanner.nextLine();

                    System.out.print("Insira o custo da consulta: ");
                    double custoConsulta = scanner.nextDouble();

                    listaDePacientes.get(indice).setCustoConsulta(custoConsulta);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Paciente inválido. Tente novamente.");
                }
            }
        }

        System.out.println("\nPacientes altualizados!");
    }

    public static void removerPaciente() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           REMOVER PACIENTES                        ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║       Selecione um ou mais pacientes para serem removidos.         ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePacientes.forEach(paciente -> {
            System.out.print("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR"));
            for (int i = 0; i < 69 - ("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de pacientes a serem removidos: ");
        qtdPacientesSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdPacientesSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do paciente na lista: ");
                int indice = scanner.nextInt() - 1; scanner.nextLine();
                if (indice < listaDePacientes.size()) {
                    listaDePacientes.get(indice).setNome(null);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Paciente inválido. Tente novamente.");
                }
            }
        }

        listaDePacientes.removeIf(f -> f.getNome() == null);

        System.out.println("Pacientes removidos!");
    }

    public static void buscarPaciente() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           BUSCAR UM PACIENTE                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║     Selecione o nome do cliente do paciente ou seu índice para     ║
                ║     buscar suas informações.                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePacientes.forEach(paciente -> {
            System.out.print("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR"));
            for (int i = 0; i < 69 - ("║  " + (listaDePacientes.indexOf(paciente) + 1) + "  ║  Nome: " + (paciente.getNome()) + (paciente.convenio ? " | CONVENIO" : " | PARTICULAR")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                           © MedVida, 2025                          ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");

        boolean opcaoInvalida = true;
        while (opcaoInvalida) {
            String entradaPacienteEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaPacienteEscolhido) - 1;
                if (indiceFuncEscolhido < listaDePacientes.size()) {
                    listaDePacientes.get(indiceFuncEscolhido).exibirInformacoes();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaPacienteEscolhido.isEmpty()) {
                    listaDePacientes.stream().filter(f -> f.getNome().equalsIgnoreCase(entradaPacienteEscolhido)).forEach(Paciente::exibirInformacoes);
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
