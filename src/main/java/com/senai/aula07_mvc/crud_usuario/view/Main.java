package com.senai.aula07_mvc.crud_usuario.view;

import com.senai.aula07_mvc.crud_usuario.controller.OperadorController;
import com.senai.aula07_mvc.crud_usuario.controller.SupervisorController;
import com.senai.aula07_mvc.crud_usuario.model.Operador;
import com.senai.aula07_mvc.crud_usuario.model.Supervisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OperadorController opController = new OperadorController();
        SupervisorController supController = new SupervisorController();

        String menu = """
                1 - Cadastrar novo usuário
                2 - Apagar um usuário
                3 - Atualizar um usuário
                4 - Exibir informações de um usuário
                5 - Ligar máquina
                6 - Demitir operador
                7 - Sair
                """;

        int opcao = scanner.nextInt(); scanner.nextLine();

        do {
            System.out.println(menu);
            opcao = scanner.nextInt(); scanner.nextLine();
            System.out.println("Qual tipo de usuário?");
            System.out.println("1 - Operador");
            System.out.println("2 - Supervisor");
            int escolhaTipo = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Preencha os dados a seguir.");

                    System.out.print("ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();

                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    if (escolhaTipo == 1) {
                        System.out.println("Setor: ");
                        String setor = scanner.nextLine();
                        Operador operador = new Operador(nome, id, setor);
                        if (opController.cadastrarOperador(operador)) {
                            System.out.println("Cadstrado com sucesso!");
                        }
                         else {
                            System.out.println("Não foi possível cadastrar o usuário.");
                        }
                    } else if (escolhaTipo == 2) {
                        System.out.println("Área: ");
                        String area = scanner.nextLine();
                        Supervisor supervisor = new Supervisor(nome, id, area);
                        if (supController.cadastrarSupervisor(supervisor)) {
                            System.out.println("Cadstrado com sucesso!");
                        } else {
                            System.out.println("Não foi possível cadastrar o usuário.");
                        }
                    }
                    break;

                case 2:
                    if (escolhaTipo == 1)
                        opController.listarOperadores().forEach(System.out::println);
                    else if (escolhaTipo == 2)
                        supController.listarSupervisores().forEach(System.out::println);

                    System.out.println("Escolha um usuário pelo ID para apagar: ");
                    id = scanner.nextInt(); scanner.nextLine();

                    if (escolhaTipo == 1)
                        opController.deletarOperador(id);
                    else if (escolhaTipo == 2)
                        supController.deletarOperador(id);

                    break;

                case 3:
                    if (escolhaTipo == 1)
                        opController.listarOperadores().forEach(System.out::println);
                    else if (escolhaTipo == 2)
                        supController.listarSupervisores().forEach(System.out::println);

                    System.out.println("Escolha um usuário pelo ID para atualizar: ");
                    id = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Atualize as seguintes informações: ");

                    System.out.println("Nome: ");
                    nome = scanner.nextLine();

                    if (escolhaTipo == 1) {
                        System.out.println("Setor: ");
                        String setor = scanner.nextLine();
                        Operador operador = new Operador(nome, id, setor);
                        opController.atualizarOperador(operador);
                    } else if (escolhaTipo == 2) {
                        System.out.println("Área: ");
                        String area = scanner.nextLine();
                        Supervisor supervisor = new Supervisor(nome, id, area);
                        supController.atualizarSupervisor(supervisor);
                    }

                    System.out.println("Usuário atualizado com sucesso.");
                    break;

                case 4:
                    if (escolhaTipo == 1)
                        opController.listarOperadores().forEach(System.out::println);
                    else if (escolhaTipo == 2)
                        supController.listarSupervisores().forEach(System.out::println);
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
