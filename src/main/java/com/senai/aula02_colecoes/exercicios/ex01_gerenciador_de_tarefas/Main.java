package com.senai.aula02_colecoes.exercicios.ex01_gerenciador_de_tarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static ArrayList<Tarefa> listaTarefas = new ArrayList<>();
    static int qtdTarefasSelecionadas;

    public static void main(String[] args) {
        do {
            mostrarMenu();
            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarTarefas();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    marcarTarefaConcluida();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerTarefa();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    encerrePrograma();
                    break;
            }
        } while (!sair);
    }

    public static void mostrarMenu() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      GERENCIADOR DE TAREFAS                        ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novas tarefas                                    ║
                ║  2  ║   Listar tarefas                                             ║
                ║  3  ║   Marcar tarefa como concluída/inconcluída                   ║
                ║  4  ║   Remover tarefas                                            ║
                ║  5  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                        © Task Manager, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarTarefa() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVAS TAREFAS                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║     Insira a quantidade de tarefas que deseja adicionar e as       ║
                ║     tarefas a serem adicionadas.                                   ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                        © Task Manager, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novas tarefas: ");
        qtdTarefasSelecionadas = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdTarefasSelecionadas; i++) {
            System.out.print("Insira a tarefa " + (i + 1) + ": ");
            listaTarefas.add(new Tarefa(scanner.nextLine(), false));
        }

        System.out.println("\nTarefas adicionadas!");
    }

    public static void listarTarefas() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           LISTAR TAREFAS                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Segue a lista de todas as tarefas e sua conclusão.         ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaTarefas.forEach(tarefa -> {
            System.out.print("║  " + (listaTarefas.indexOf(tarefa) + 1) + "  ║  " + tarefa);
            for (int i = 0; i < 69 - ("║  " + listaTarefas.indexOf(tarefa) + "  ║  " + tarefa).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                        © Task Manager, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
    }

    public static void marcarTarefaConcluida() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║            MARCAR TAREFAS COMO CONCLUÍDAS/INCONCLUÍDAS             ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║          Selecione uma ou mais tarefas para marcar como            ║
                ║          concluídas ou inconcluídas.                               ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaTarefas.forEach(tarefa -> {
            System.out.print("║  " + (listaTarefas.indexOf(tarefa) + 1) + "  ║  " + tarefa.nome + " | Concluída? " + (tarefa.concluido ? "Sim" : "Não"));
            for (int i = 0; i < 69 - ("║  " + listaTarefas.indexOf(tarefa) + "  ║  " + tarefa.nome + " | Concluída? " + (tarefa.concluido ? "Sim" : "Não")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                        © Task Manager, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de tarefas a terem sua conclusão alterada: ");
        qtdTarefasSelecionadas = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdTarefasSelecionadas; i++) {
            System.out.print("(" + (i + 1) + ") Índice da tarefa na lista: ");
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();
            listaTarefas.get(indice).concluido = !listaTarefas.get(indice).concluido;
        }

        System.out.println("\nTarefas alteradas!");
    }

    public static void removerTarefa() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                          REMOVER TAREFAS                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione uma ou mais tarefas para serem removidas.        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaTarefas.forEach(tarefa -> {
            System.out.print("║  " + (listaTarefas.indexOf(tarefa) + 1) + "  ║  " + tarefa.nome);
            for (int i = 0; i < 69 - ("║  " + listaTarefas.indexOf(tarefa) + "  ║  " + tarefa.nome).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                        © Task Manager, 2025                        ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de tarefas a serem removidas: ");
        qtdTarefasSelecionadas = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdTarefasSelecionadas; i++) {
            System.out.print("\n(" + (i + 1) + ")\nÍndice da tarefa na lista: ");
            listaTarefas.get(scanner.nextInt() - 1).nome = null;
            scanner.nextLine();
        }

        // Intenção: usar o laço 'for-each' para remover cada elemento dada uma condição
        // Recomendação do IntelliJ: usar 'removeIf' em vez do laço 'for-each'
        listaTarefas.removeIf(tarefa -> tarefa.nome == null);

        System.out.println("\nTarefas removidas!");
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