package com.senai.aula07_mvc.crud_usuario.view;

import com.senai.aula07_mvc.crud_usuario.controller.OperadorController;
import com.senai.aula07_mvc.crud_usuario.controller.SupervisorController;
import com.senai.aula07_mvc.crud_usuario.model.Operador;
import com.senai.aula07_mvc.crud_usuario.model.Supervisor;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OperadorController operadorController = new OperadorController();
        SupervisorController supervisorController = new SupervisorController();

        String menu = """
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
                """;

        int opcao;

        do {
            System.out.print(menu + " > ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // Cadastro
                    System.out.print("""
                            \nQual tipo de usuário?
                             | 1 - Operador
                             | 2 - Supervisor
                             >\s""");
                    int escolhaTipo = scanner.nextInt();

                    System.out.println("\nPreencha os dados a seguir:");

                    System.out.print("1 - ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("2 - Nome: ");
                    String nome = scanner.nextLine();

                    if (escolhaTipo == 1) {
                        System.out.print("3 - Setor: ");
                        String setor = scanner.nextLine();
                        Operador operadorerador = new Operador(nome, id, setor);
                        if (operadorController.cadastrarOperador(operadorerador)) {
                            System.out.println("\nCadstrado com sucesso!");
                        } else {
                            System.out.println("\nNão foi possível cadastrar o usuário.");
                        }
                    } else if (escolhaTipo == 2) {
                        System.out.print("3 - Área: ");
                        String area = scanner.nextLine();
                        Supervisor supervisorervisor = new Supervisor(nome, id, area);
                        if (supervisorController.cadastrarSupervisor(supervisorervisor)) {
                            System.out.println("\nCadstrado com sucesso!");
                        } else {
                            System.out.println("\nNão foi possível cadastrar o usuário.");
                        }
                    }
                    break;

                case 2: // Listar
                    if (escolhaTipo == 1)
                        operadorController.listarOperadores().forEach(System.out::println);
                    else if (escolhaTipo == 2)
                        supervisorController.listarSupervisores().forEach(System.out::println);
                    break;

                case 3: // Atualizar
                    if (escolhaTipo == 1)
                        operadorController.listarOperadores().forEach(System.out::println);
                    else if (escolhaTipo == 2)
                        supervisorController.listarSupervisores().forEach(System.out::println);

                    System.out.println("Escolha um usuário pelo ID para atualizar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Atualize as seguintes informações: ");

                    System.out.print("Nome: ");
                    nome = scanner.nextLine();

                    if (escolhaTipo == 1) {
                        System.out.print("Setor: ");
                        String setor = scanner.nextLine();
                        Operador operadorerador = new Operador(nome, id, setor);
                        operadorController.atualizarOperador(operadorerador);
                    } else if (escolhaTipo == 2) {
                        System.out.print("Área: ");
                        String area = scanner.nextLine();
                        Supervisor supervisorervisor = new Supervisor(nome, id, area);
                        supervisorController.atualizarSupervisor(supervisorervisor);
                    }

                    System.out.println("Usuário atualizado com sucesso.");
                    break;

                case 4: // Remover
                    if (escolhaTipo == 1)
                        operadorController.listarOperadores().forEach(System.out::println);
                    else if (escolhaTipo == 2)
                        supervisorController.listarSupervisores().forEach(System.out::println);

                    System.out.println("Escolha um usuário pelo ID para apagar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaTipo == 1)
                        operadorController.deletarOperador(id);
                    else if (escolhaTipo == 2)
                        supervisorController.deletarOperador(id);

                    break;

                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    scanner.close();
                    break;
            }
        } while (opcao != 7);
    }
}
