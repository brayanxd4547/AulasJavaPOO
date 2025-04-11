package com.senai.aula04_heranca.exercicios.ex03_sistema_de_gestao_de_pedidos;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static List<String> listaTiposDePedidos = new ArrayList<>(List.of("Presencial", "Online"));
    static List<Pedido> listaDePedidos = new ArrayList<>(List.of(
            new PedidoOnline("Arnoldo", 90, new ArrayList<>(List.of("hambúrguer", "batata frita", "refrigerante")), 30),
            new PedidoPresencial("Beatriz", 110, new ArrayList<>(List.of("hambúrguer", "batata frita", "refrigerante", "sundae de morango")), 12),
            new PedidoOnline("Creuso", 30, new ArrayList<>(List.of("hambúrguer")), 10)
    ));

    static public String[] atributosPadraoPedido = {"Cliente", "Valor Original", "Quantidade de componentes do pedido"};
    static int qtdPedidosSelecionados;

    public static void main(String[] args) {
        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarPedidos();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarPedidos();
                    break;

                case 3:
                    atualizarInfoPedido();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 4:
                    removerPedido();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 5:
                    buscarPedido();
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
                ║                       CONTROLE DE PEDIDOS                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novos pedidos                                    ║
                ║  2  ║   Listar todos os pedidos                                    ║
                ║  3  ║   Atualizar componentes de um pedido                         ║
                ║  4  ║   Remover um pedido                                          ║
                ║  5  ║   Buscar informações de um pedido                            ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarPedidos() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS PEDIDOS                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║      Insira o tipo do pedido que deseja adicionar.                 ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaTiposDePedidos.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDePedidos.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDePedidos.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int tipoSelecionado = scanner.nextInt() - 1;
        while (tipoSelecionado >= listaTiposDePedidos.size() || tipoSelecionado < 0) {
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS PEDIDOS                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║      Insira as seguintes informações sobre o pedido:               ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos pedidos: ");
        qtdPedidosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdPedidosSelecionados; i++) {
            System.out.println("\nDigite as seguintes componentes sobre o pedido.");
            String[] atributosNovoPedido = new String[atributosPadraoPedido.length];
            for (int j = 0; j < atributosPadraoPedido.length; j++) {
                System.out.print(atributosPadraoPedido[j] + ": ");
                atributosNovoPedido[j] = scanner.nextLine();
            }

            switch (tipoSelecionado) {
                case 0:
                    System.out.print("Desconto à vista: ");
                    double descontoVista = scanner.nextDouble();

                    listaDePedidos.add(new PedidoPresencial(atributosNovoPedido[0], Float.parseFloat(atributosNovoPedido[1]), escolhaComponentes(Integer.parseInt(atributosNovoPedido[2])), descontoVista));
                    break;

                case 1:
                    System.out.print("Taxa de entrega: ");
                    double taxaEntrega = scanner.nextDouble();

                    listaDePedidos.add(new PedidoOnline(atributosNovoPedido[0], Float.parseFloat(atributosNovoPedido[1]), escolhaComponentes(Integer.parseInt(atributosNovoPedido[2])), taxaEntrega));
                    break;
            }

            System.out.println("\nPedido adicionado com sucesso!");
        }
    }

    public static List<String> escolhaComponentes(int qtdComponentes) {
        List<String> listaComponentes = new ArrayList<>();
        for (int j = 0; j < qtdComponentes; j++) {
            System.out.print("Insira o componente do pedido (" + (j + 1) + "): ");
            listaComponentes.add(scanner.nextLine());
        }

        return listaComponentes;
    }

    public static void listarPedidos() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           LISTAR PEDIDOS                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                 Segue a lista de todos os pedidos.                 ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePedidos.forEach(pedido -> {
            System.out.print("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL"));
            for (int i = 0; i < 69 - ("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while (true) {
            System.out.print("\nDigite o índice do pedido na lista para verificar suas componentes específicas ou não digite nada para voltar ao início.\n>> ");
            String entradaFuncEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaFuncEscolhido) - 1;
                if (indiceFuncEscolhido < listaDePedidos.size()) {
                    listaDePedidos.get(indiceFuncEscolhido).exibirInformacoes();
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

    public static void atualizarInfoPedido() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                  ATUALIZAR COMPONENTES DE PEDIDOS                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais pedidos para atualizar os seus           ║
                ║      componentes.                                                  ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePedidos.forEach(pedido -> {
            System.out.print("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL"));
            for (int i = 0; i < 69 - ("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de pedidos a terem seus componentes alterados: ");
        qtdPedidosSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdPedidosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do pedido na lista: ");
                int indice = scanner.nextInt() - 1;
                if (indice < listaDePedidos.size()) {
                    scanner.nextLine();

                    System.out.print("Insira a quantidade de componentes do pedido: ");
                    int qtdComponentes = scanner.nextInt(); scanner.nextLine();

                    listaDePedidos.get(indice).setComponentes(escolhaComponentes(qtdComponentes));
                    opcaoInvalida = false;
                } else {
                    System.out.println("Pedido inválido. Tente novamente.");
                }
            }
        }

        System.out.println("\nPedidos altualizados!");
    }

    public static void removerPedido() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           REMOVER PEDIDOS                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║       Selecione um ou mais pedidos para serem removidos.           ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePedidos.forEach(pedido -> {
            System.out.print("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL"));
            for (int i = 0; i < 69 - ("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de pedidos a serem removidos: ");
        qtdPedidosSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdPedidosSelecionados; i++) {
            boolean opcaoInvalida = true;
            while (opcaoInvalida) {
                System.out.print("\n(" + (i + 1) + ")\nÍndice do pedido na lista: ");
                int indice = scanner.nextInt() - 1; scanner.nextLine();
                if (indice < listaDePedidos.size()) {
                    listaDePedidos.get(indice).setCliente(null);
                    opcaoInvalida = false;
                } else {
                    System.out.println("Pedido inválido. Tente novamente.");
                }
            }
        }

        listaDePedidos.removeIf(f -> f.getCliente() == null);

        System.out.println("Pedidos removidos!");
    }

    public static void buscarPedido() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           BUSCAR UM PEDIDO                         ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║     Selecione o nome do cliente do pedido ou seu índice para       ║
                ║     buscar suas informações.                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDePedidos.forEach(pedido -> {
            System.out.print("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL"));
            for (int i = 0; i < 69 - ("║  " + (listaDePedidos.indexOf(pedido) + 1) + "  ║  COD: " + (pedido.getNumPedido()) + " | Cliente: " + (pedido.getCliente()) + (pedido.isOnline() ? " | ONLINE" : " | PRESENCIAL")).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Pizzaria Fortepiano, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");

        boolean opcaoInvalida = true;
        while (opcaoInvalida) {
            String entradaPedidoEscolhido = scanner.nextLine();

            // Usar try catch para testar o tipo de entrada (int ou String)
            try {
                int indiceFuncEscolhido = Integer.parseInt(entradaPedidoEscolhido) - 1;
                if (indiceFuncEscolhido < listaDePedidos.size()) {
                    listaDePedidos.get(indiceFuncEscolhido).exibirInformacoes();
                    opcaoInvalida = false;
                } else {
                    System.out.println("Esta opção não é válida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                if (!entradaPedidoEscolhido.isEmpty()) {
                    listaDePedidos.stream().filter(f -> f.getCliente().equalsIgnoreCase(entradaPedidoEscolhido)).forEach(Pedido::exibirInformacoes);
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