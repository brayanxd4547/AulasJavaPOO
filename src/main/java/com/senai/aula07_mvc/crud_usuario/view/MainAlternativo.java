package com.senai.aula07_mvc.crud_usuario.view;

import com.senai.aula07_mvc.crud_usuario.controller.OperadorController;
import com.senai.aula07_mvc.crud_usuario.controller.SupervisorController;
import com.senai.aula07_mvc.crud_usuario.model.Operador;
import com.senai.aula07_mvc.crud_usuario.model.Supervisor;
import com.senai.aula07_mvc.crud_usuario.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAlternativo {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static List<String> listaTiposDeUsuario = new ArrayList<>(List.of("Operador", "Supervisor"));
    static List<Usuario> listaDeUsuarios = new ArrayList<>(/*List.of(
            new Operador("Gestão de vendas - Escalario", 30),
            new Supervisor("Expansão da malha ferroviária - ViaMobilidade", 120)
    )*/);

    static public String[] atributosPadraoUsuario = {"ID", "Nome"};
    static int qtdUsuariosSelecionados;

    public static void main(String[] args) {
        OperadorController opController = new OperadorController();
        SupervisorController supController = new SupervisorController();

        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    cadastrarUsuarios();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarUsuarios();
                    break;

                case 3:
                    atualizarInfoUsuario();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerUsuario();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarUsuario();
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
                ║                CONTROLE DE OPERADORES E SUPERVISORES               ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Cadastrar novo usuário                                     ║
                ║  2  ║   Listar todos os usuários                                   ║
                ║  3  ║   Atualizar informações de um usuário                        ║
                ║  4  ║   Remover um usuário                                         ║
                ║  5  ║   Buscar informações de um usuário                           ║
                ║  6  ║   Ligar máquina                                              ║
                ║  7  ║   Demitir operador                                           ║
                ║  8  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                        © Enterpreuner, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void cadastrarUsuarios() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                CADASTRAR OPERADORES OU SUPERVISORES                ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║           Insira o tipo de usuário que deseja cadastrar.           ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaTiposDeUsuario.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDeUsuario.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDeUsuario.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © Enterpreuner, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int tipoSelecionado = scanner.nextInt() - 1;
        while (tipoSelecionado >= listaTiposDeUsuario.size() || tipoSelecionado < 0) {
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                        CADASTRAR NOVOS RELATÓRIOS                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║         Insira as seguintes informações sobre os usuários.         ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © Enterpreuner, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos usuários: ");
        qtdUsuariosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdUsuariosSelecionados; i++) {
            System.out.println("\nDigite as seguintes informações sobre o usuário.");
            String[] atributosNovoUsuario = new String[atributosPadraoUsuario.length];
            for (int j = 0; j < atributosPadraoUsuario.length; j++) {
                System.out.print(atributosPadraoUsuario[j] + ": ");
                atributosNovoUsuario[j] = scanner.nextLine();
            }

            switch (tipoSelecionado){
                case 1:
                    listaDeUsuarios.add(new Usuario(atributosNovoUsuario[0], Integer.parseInt(atributosNovoUsuario[1])));
                    break;
                case 2:
                    break;
                default:
            }
            listaDeUsuarios.add(new Usuario(atributosNovoUsuario[0], Integer.parseInt(atributosNovoUsuario[1])));
            listaDeUsuarios.getLast().cadastrar();
        }
    }

    public static void listarUsuarios() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         LISTAR RELATÓRIOS                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                 Segue a lista de todos os usuários.                ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeUsuarios.forEach(usuario -> {
            System.out.print("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © Enterpreuner, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while (true) {
            System.out.print("\nDigite o índice do usuario na lista para verificar suas informações específicas ou não digite nada para voltar ao início.\n>> ");
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeUsuarios.size()) {
                    listaDeUsuarios.get(indiceFuncEscolhido).exibirInformacoes();
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

    public static void atualizarInfoUsuario() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                          ATUALIZAR RELATÓRIOS                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais usuários para atualizar as suas        ║
                ║      informações.                                                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeUsuarios.forEach(usuario -> {
            System.out.print("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © Enterpreuner, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de usuários a terem o custo de suas informações alteradas: ");
        qtdUsuariosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdUsuariosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do usuario na lista: ");
                int indice = scanner.nextInt() - 1;
                if (indice < listaDeUsuarios.size()) {
                    scanner.nextLine();

                    System.out.println("\nDigite as seguintes informações sobre o usuario.");
                    String[] atributosNovoUsuario = new String[atributosPadraoUsuario.length];
                    for (int j = 0; j < atributosPadraoUsuario.length; j++) {
                        System.out.print(atributosPadraoUsuario[j] + ": ");
                        atributosNovoUsuario[j] = scanner.nextLine();
                    }

                    switch (listaDeUsuarios.get(indice).tipo) {
                        case "pdf":
                            listaDeUsuarios.set(indice, new UsuarioPDF(atributosNovoUsuario[0], Integer.parseInt(atributosNovoUsuario[1])));
                            break;

                        case "json":
                            listaDeUsuarios.set(indice, new UsuarioJSON(atributosNovoUsuario[0], Integer.parseInt(atributosNovoUsuario[1])));
                            break;

                        case "csv":
                            listaDeUsuarios.set(indice, new UsuarioCSV(atributosNovoUsuario[0], Integer.parseInt(atributosNovoUsuario[1])));
                            break;
                    }
                    opcaoInvalida = false;
                } else {
                    System.out.println("Usuario inválido. Tente novamente.");
                }
            }
        }

        System.out.println("\nUsuarios altualizados!");
    }

    public static void removerUsuario() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           REMOVER RELATÓRIOS                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║       Selecione um ou mais usuários para serem removidos.        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeUsuarios.forEach(usuario -> {
            System.out.print("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © Enterpreuner, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de usuários a serem removidos: ");
        qtdUsuariosSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdUsuariosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do usuario na lista: ");
                int indice = scanner.nextInt() - 1;
                scanner.nextLine();
                if (indice < listaDeUsuarios.size()) {
                    listaDeUsuarios.get(indice).setTitulo(null);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Usuario inválido. Tente novamente.");
                }
            }
        }

        listaDeUsuarios.removeIf(f -> f.getTitulo() == null);

        System.out.println("Usuarios removidos!");
    }

    public static void buscarUsuario() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           BUSCAR UM RELATÓRIO                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║     Selecione o título do usuario ou seu índice para buscar      ║
                ║     suas informações.                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeUsuarios.forEach(usuario -> {
            System.out.print("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo()));
            for (int i = 0; i < 69 - ("║  " + (listaDeUsuarios.indexOf(usuario) + 1) + "  ║  Titulo: " + (usuario.getTitulo())).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                       © Enterpreuner, 2025                         ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");

        boolean opcaoInvalida = true;
        while (opcaoInvalida) {
            String entradaUsuarioEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaUsuarioEscolhido) - 1;
                if (indiceFuncEscolhido < listaDeUsuarios.size()) {
                    listaDeUsuarios.get(indiceFuncEscolhido).exibirInformacoes();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaUsuarioEscolhido.isEmpty()) {
                    listaDeUsuarios.stream().filter(f -> f.getTitulo().equalsIgnoreCase(entradaUsuarioEscolhido)).forEach(Usuario::exibirInformacoes);
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