package com.senai.aula04_heranca.exercicios.ex02_sistema_de_funcionarios;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static List<String> listaCargosDeFuncionarios = new ArrayList<>(Arrays.asList("Coordenador", "Professor"));
    static List<Funcionario> listaDeFuncionarios = new ArrayList<>(Arrays.asList(
            new Professor("Alisson", 3000, "Física"),
            new Professor("Bruno", 3400, "Redação"),
            new Professor("Cássio", 3400, "Gramática"),
            new Professor("Douglas", 3400, "Literatura")
    ));

    static public String[] atributosPadraoFuncionario = {"Nome", "Salário"};
    static int qtdFuncionariosSelecionados;

    public static void main(String[] args) {
        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarFuncionarios();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarFuncionarios();
                    break;

                case 3:
                    atualizarInfoFuncionario();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerFuncionario();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarFuncionario();
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

                    listaDeFuncionarios.add(new Coordenador(atributosNovoFuncionario[0], Float.parseFloat(atributosNovoFuncionario[1]), escolhaProfessores(qtdProfessores)));
                    break;

                case 1:
                    System.out.print("Disciplina do professor: ");
                    String disciplina = scanner.nextLine();

                    listaDeFuncionarios.add(new Professor(atributosNovoFuncionario[0], Float.parseFloat(atributosNovoFuncionario[1]), disciplina));
                    break;
            }

            System.out.println("\nFuncionário adicionado com sucesso!");
        }
    }

    public static List<Professor> escolhaProfessores(int qtdProfessores) {
        List<Professor> equipeProfessores = new ArrayList<>();
        for (int j = 0; j < qtdProfessores; j++) {
            boolean funcEscolhido = false;
            boolean funcProfessor = false;

            while (!funcEscolhido || !funcProfessor) {
                System.out.print("Insira o nome do professor (" + (j + 1) + "): ");
                String nomeProfEscolhido = scanner.nextLine();

                for (Funcionario funcionario : listaDeFuncionarios) {
                    if (funcionario.getNome().equalsIgnoreCase(nomeProfEscolhido)) {
                        funcEscolhido = true;
                        if (funcionario instanceof Professor) {
                            if (!equipeProfessores.contains(funcionario)) { // Caso a lista já contenha o elemento, ele é ignorado
                                equipeProfessores.add((Professor) funcionario);
                            }
                            funcProfessor = true;
                        }
                        break;
                    }
                }

                if (!funcEscolhido) {
                    System.out.println("O funcionário solicitado não existe na lista. Tente novamente.");
                } else if (!funcProfessor) {
                    System.out.println("O funcionário solicitado não é um professor. Tente novamente.");
                }
            }
        }

        return equipeProfessores;
    }

    public static void listarFuncionarios() {
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

        while (true) {
            System.out.print("\nDigite o índice do funcionário na lista para verificar suas informações específicas ou não digite nada para voltar ao início.\n>> ");
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeFuncionarios.size()) {
                    listaDeFuncionarios.get(indiceFuncEscolhido).exibirInformacoes();
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

    public static void atualizarInfoFuncionario() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                 ATUALIZAR SALÁRIO DE FUNCIONÁRIOS                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais funcionarios para atualizar os seus      ║
                ║      salários.                                                     ║
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

        System.out.print("Quantidade de funcionários a terem seus salários alterados: ");
        qtdFuncionariosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdFuncionariosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do funcionário na lista: ");
                int indice = scanner.nextInt() - 1;
                if (indice < listaDeFuncionarios.size()) {
                    scanner.nextLine();
                    System.out.print("Novo salário de " + listaDeFuncionarios.get(indice).getNome() + ": ");
                    listaDeFuncionarios.get(indice).setSalario(scanner.nextDouble());
                    scanner.nextLine();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Funcionário inválido. Tente novamente.");
                }
            }
        }

        System.out.println("\nFuncionários altualizados!");
    }

    public static void removerFuncionario() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                       REMOVER FUNCIONÁRIOS                         ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║       Selecione um ou mais funcionários para serem removidos.      ║
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

        System.out.print("Quantidade de funcionários a serem removidos: ");
        qtdFuncionariosSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdFuncionariosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do funcionário na lista: ");
                int indice = scanner.nextInt() - 1; scanner.nextLine();
                if (indice < listaDeFuncionarios.size()) {
                    listaDeFuncionarios.get(indice).setNome(null);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Funcionário inválido. Tente novamente.");
                }
            }
        }

        listaDeFuncionarios.removeIf(f -> f.getNome() == null);

        System.out.println("Funcionários removidos!");
    }

    public static void buscarFuncionario() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                       BUSCAR UM FUNCIONÁRIO                        ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║     Selecione o nome do funcionário ou seu índice para buscar      ║
                ║     suas informações.                                              ║
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

        System.out.print(">> ");

        boolean opcaoInvalida = true;
        while (opcaoInvalida){
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeFuncionarios.size()) {
                    listaDeFuncionarios.get(indiceFuncEscolhido).exibirInformacoes();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaFuncEscolhido.isEmpty()) {
                    listaDeFuncionarios.stream().filter(f -> f.getNome().equalsIgnoreCase(entradaFuncEscolhido)).forEach(Funcionario::exibirInformacoes);
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