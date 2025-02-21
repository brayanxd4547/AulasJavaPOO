package com.senai.aula01_introducao_poo.exercicios.ex02_gerenciamento_de_alunos;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static Aluno[] matrizAlunos = {
            new Aluno("Roberto Fonseca", 10, 8.3f),
            new Aluno("Carlos Drummond", 15, 6.2f),
            new Aluno("Inácio Pereira", 17, 9)
    };
    static int alunoSelecionado;

    //todo BORA TRABALHAR

    public static void main(String[] args) {
        do {
            mostrarMenu();
            switch (opcao) {
                case 1:
                    registreNovoAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    exibirInformacoesDeAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 3:
                    atualizeAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    apagueAluno();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    verifiqueAprovacaoDeAluno();
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
                ║                               MENU                                 ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Registrar novos alunos                                     ║
                ║  2  ║   Exibir informações de um aluno                             ║
                ║  3  ║   Atualizar a nota de um produto                             ║
                ║  4  ║   Apagar o registro de um aluno                              ║
                ║  5  ║   Verificar aprovação de aluno                               ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void registreNovoAluno() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                 CRIAR NOVOS REGISTRO DE UM ALUNO                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║     Insira a quantidade de aluos que deseja registrar e os         ║
                ║     seus dados.                                                    ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        int qtdNovosAlunos = scanner.nextInt();
        scanner.nextLine();
        Aluno[] novaMatrizAlunos = new Aluno[qtdNovosAlunos + matrizAlunos.length];

        for (int i = 0; i < matrizAlunos.length; i++) {
            novaMatrizAlunos[i] = matrizAlunos[i];
        }

        for (int i = matrizAlunos.length; i < novaMatrizAlunos.length; i++) {
            String[] dadosAluno = new String[3];

            System.out.println("Nome do aluno: ");
            dadosAluno[0] = scanner.nextLine();

            System.out.println("Idade do aluno: ");
            dadosAluno[1] = scanner.nextLine();

            System.out.println("Nota do aluno: ");
            dadosAluno[2] = scanner.nextLine();

            novaMatrizAlunos[i] = new Aluno(dadosAluno[0], Integer.parseInt(dadosAluno[1]), Float.parseFloat(dadosAluno[2]));

            System.out.println("______________________________\n");
        }

        matrizAlunos = novaMatrizAlunos;

        System.out.println("Novos alunos registrados com sucesso!\n");
        for (Aluno aluno : matrizAlunos) {
            System.out.println(aluno);
        }
    }

    public static void exibirInformacoesDeAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                 EXIBIR INFORMAÇÕES DE UM ALUNO                     ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione um aluno para visualizar as informações:         ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome);
            for (int j = 0; j < 59 - matrizAlunos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        alunoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println(matrizAlunos[alunoSelecionado]);
    }

    public static void atualizeAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                ATUALIZAR O ESTOQUE DE UM PRODUTO                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║             Selecione um aluno para atualizar as nota:             ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome);
            for (int j = 0; j < 59 - matrizAlunos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        alunoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("Insira a nova nota para " + matrizAlunos[alunoSelecionado].nome + ": ");
        matrizAlunos[alunoSelecionado].atualizaNota(scanner.nextInt());
        scanner.nextLine();

        System.out.println(matrizAlunos[alunoSelecionado]);
    }

    public static void verifiqueAprovacaoDeAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║           VERIFIQUE APROVAÇÃO DE ALUNO POR NOTA AVALIATIVA         ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║             Selecione um aluno para verificar aprovação:           ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome);
            for (int j = 0; j < 59 - matrizAlunos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        alunoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("O aluno " + (!matrizAlunos[alunoSelecionado].verificarAprovacao() ? "não " : "") + "está aprovado.");
    }

    public static void apagueAluno() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                    REMOVER UM REGISTRO DE ALUNO                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║               Selecione um aluno para ser removido:                ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        for (int i = 0; i < matrizAlunos.length; i++) {
            System.out.print("║  " + (i + 1) + "  ║   " + matrizAlunos[i].nome);
            for (int j = 0; j < 59 - matrizAlunos[i].nome.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                © Colégio Espaço Potencial, 2025                    ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        alunoSelecionado = scanner.nextInt() - 1;
        scanner.nextLine();
        Aluno[] novaMatrizAlunos = new Aluno[matrizAlunos.length - 1];

        int i = 0;
        for (int j = 0; j < matrizAlunos.length; j++) {
            if (alunoSelecionado != j){
                novaMatrizAlunos[i] = matrizAlunos[j];
                i++;
            }
        }

        matrizAlunos = novaMatrizAlunos;

        System.out.println("Registro removido com sucesso!\n");
        for (Aluno aluno : matrizAlunos) {
            System.out.println(aluno);
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