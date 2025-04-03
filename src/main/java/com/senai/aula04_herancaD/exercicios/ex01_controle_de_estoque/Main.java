package com.senai.aula04_herancaD.exercicios.ex01_controle_de_estoque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int opcao;
    static boolean sair = false;

    static ArrayList<String> listaTiposDeProdutos = new ArrayList<>(Arrays.asList("Alimento", "Brindquedo", "Eletrônico", "Roupa"));
    static ArrayList<Estoque> listaDeEstoques = new ArrayList<>();

    static public String[] atributosPadraoProduto = {"Nome", "Preço", "Marca"};
    static int qtdEstoquesSelecionados;

    public static void main(String[] args) {
        listaDeEstoques.add(new Estoque(new Alimento("maçã", 3, "Pomera Agro", "23-04-2025"), 1000));
        listaDeEstoques.add(new Estoque(new Brinquedo("baldinho de areia", 5, "Play-full", "vermelho"), 1000));
        listaDeEstoques.add(new Estoque(new Eletronico("ventilador", 300, "Mondeal", 110, 2), 2000));
        listaDeEstoques.add(new Estoque(new Roupa("calça jeans", 100, "Levi's", "azul claro"), 1000));

        do {
            mostrarMenu();

            switch (opcao) {
                case 1:
                    adicionarEstoques();
                    System.out.println("Digite qualquer tecla para continuar...");
                    scanner.nextLine();
                    break;

                case 2:
                    listarEstoques();
                    break;

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
                    break;
            }
        } while (!sair);
    }

    public static void mostrarMenu() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                  CONTROLE DE ESTOQUE DE PRODUTOS                   ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  Selecione uma opção:                                              ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║  1  ║   Adicionar novos estoques de produtos                       ║
                ║  2  ║   Listar todos os estoques                                   ║
                ║  3  ║   Atualizar quantidade de produtos em um estoque             ║
                ║  4  ║   Remover um estoque de produtos                             ║
                ║  5  ║   Buscar informações de um estoque pelo nome do produto      ║
                ║  6  ║   Sair                                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);
        opcao = scanner.nextInt();
        scanner.nextLine();
    }

    public static void adicionarEstoques() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS ESTOQUES                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║     Insira o tipo do produto do estoque que deseja adicionar.      ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣""");
        listaTiposDeProdutos.forEach(tipo -> {
            System.out.print("║  " + (listaTiposDeProdutos.indexOf(tipo) + 1) + "  ║  " + tipo);
            for (int i = 0; i < 69 - ("║  " + listaTiposDeProdutos.indexOf(tipo) + "  ║  " + tipo).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        int tipoProdutoSelecionado = scanner.nextInt() - 1;
        while (tipoProdutoSelecionado >= listaTiposDeProdutos.size() || tipoProdutoSelecionado < 0){
            System.out.println("Tipo selecionado inválido. Tente novamente.");
            tipoProdutoSelecionado = scanner.nextInt() - 1;
        }

        System.out.println("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                      ADICIONAR NOVOS ESTOQUES                      ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                                                                    ║
                ║     Insira as seguintes informações sobre os novos estoques:       ║
                ║                                                                    ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de novos estoques: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdEstoquesSelecionados; i++) {
            System.out.println("\nDigite as seguintes informações sobre o produto.");
            String[] atributosNovoProduto = new String[3];
            for (int j = 0; j < atributosPadraoProduto.length; j++) {
                System.out.print(atributosPadraoProduto[j] + ": ");
                atributosNovoProduto[j] = scanner.nextLine();
            }
            System.out.print("Quantidade do produto nesse estoque: ");
            int qtdProduto = scanner.nextInt();

            switch (tipoProdutoSelecionado) {
                case 0:
                    System.out.print("Data de validade: ");
                    String dataValidade = scanner.nextLine();

                    listaDeEstoques.add(new Estoque(new Alimento(atributosNovoProduto[0], Float.parseFloat(atributosNovoProduto[1]), atributosNovoProduto[2], dataValidade), qtdProduto));
                    break;
                case 1:
                    System.out.print("Cor do brinquedo: ");
                    String corBrinquedo = scanner.nextLine();

                    listaDeEstoques.add(new Estoque(new Brinquedo(atributosNovoProduto[0], Float.parseFloat(atributosNovoProduto[1]), atributosNovoProduto[2], corBrinquedo), qtdProduto));
                    break;
                case 3:
                    System.out.print("Tensão elétrica: ");
                    float tensaoEletrica = scanner.nextFloat();

                    System.out.print("Corrente elétrica: ");
                    float correnteEletrica = scanner.nextFloat();

                    listaDeEstoques.add(new Estoque(new Eletronico(atributosNovoProduto[0], Float.parseFloat(atributosNovoProduto[1]), atributosNovoProduto[2], tensaoEletrica, correnteEletrica), qtdProduto));
                    break;
                case 4:
                    System.out.print("Cor do roupa: ");
                    String corRoupa = scanner.nextLine();

                    listaDeEstoques.add(new Estoque(new Roupa(atributosNovoProduto[0], Float.parseFloat(atributosNovoProduto[1]), atributosNovoProduto[2], corRoupa), qtdProduto));
                    break;
            }
            scanner.nextLine();
        }

        System.out.println("\nEstoques adicionados!");
    }

    public static void listarEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                           LISTAR ESTOQUES                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Segue a lista de todos os estoques de produtos.            ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);

        listaDeEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + (estoque.getProduto().getNome()) + " (marca " + estoque.getProduto().getMarca() + ") | Quantidade: " + estoque.getQuantidade());
            for (int i = 0; i < 69 - ("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + (estoque.getProduto().getNome()) + " (marca " + estoque.getProduto().getMarca() + ") | Quantidade: " + estoque.getQuantidade()).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        while(true){
            System.out.print("\nDigite o índice do produto na lista para verificar suas informações específicas ou não digite nada para voltar ao início.\n>> ");
            String opcaoInformacoes = scanner.nextLine();
            try {
                listaDeEstoques.get(Integer.parseInt(opcaoInformacoes) - 1).getProduto().exibirInformacoes();
            } catch (NumberFormatException e){
                if (!opcaoInformacoes.isEmpty()){
                    System.out.println("Esta opção não é válida. Tente novamente.");
                } else {
                    break;
                }
            }
        }
    }

    public static void atualizarQtdProdutos() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║           ATUALIZAR QUANTIDADE DE PRODUTOS NOS ESTOQUES            ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║      Selecione um ou mais estoques para atualizar a sua            ║
                ║      quantidade de produtos.                                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto().getNome() + " | Quantidade: " + estoque.getQuantidade());
            for (int i = 0; i < 69 - ("║  " + listaDeEstoques.indexOf(estoque) + "  ║  " + estoque.getProduto().getNome() + " | Quantidade: " + estoque.getQuantidade()).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de estoques a terem sua quantidade de produtos alterada: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < qtdEstoquesSelecionados; i++) {
            System.out.print("\n(" + (i + 1) + ")\nÍndice do estoque na lista: ");
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();
            System.out.print("Nova quantidade de " + listaDeEstoques.get(indice).getProduto().getNome() + " no estoque: ");
            listaDeEstoques.get(indice).setQuantidade(scanner.nextInt());
            scanner.nextLine();
        }

        System.out.println("\nEstoques alterados!");
    }


    public static void removerEstoques() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         REMOVER ESTOQUES                           ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione um ou mais estoques para serem removidos.        ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto().getNome());
            for (int i = 0; i < 69 - ("║  " + listaDeEstoques.indexOf(estoque) + "  ║  " + estoque.getProduto().getNome()).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print("Quantidade de estoques a serem removidos: ");
        qtdEstoquesSelecionados = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdEstoquesSelecionados; i++) {
            System.out.print("\n(" + (i + 1) + ")\nÍndice do estoque na lista: ");
            listaDeEstoques.get(scanner.nextInt() - 1).setProduto(null);
            scanner.nextLine();
        }

        listaDeEstoques.removeIf(estoque -> estoque.getProduto() == null);

        System.out.println("Estoques removidos!");
    }


    public static void buscarEstoque() {
        System.out.print("""
                ╔════════════════════════════════════════════════════════════════════╗
                ║                         BUSCAR UM ESTOQUE                          ║
                ╠════════════════════════════════════════════════════════════════════╣
                ║         Selecione o nome do produto de um estoque ou seu           ║
                ║         índice para buscar suas informações.                       ║
                ╠════════════════════════════════════════════════════════════════════╣
                """);
        listaDeEstoques.forEach(estoque -> {
            System.out.print("║  " + (listaDeEstoques.indexOf(estoque) + 1) + "  ║  " + estoque.getProduto().getNome());
            for (int i = 0; i < 69 - ("║  " + listaDeEstoques.indexOf(estoque) + "  ║  " + estoque.getProduto().getNome()).length(); i++) {
                System.out.print(" ");
            }
            System.out.println("║");
        });
        System.out.println("""
                ╠════════════════════════════════════════════════════════════════════╣
                ║                    © Lopes Supermercados, 2025                     ║
                ╚════════════════════════════════════════════════════════════════════╝
                """);

        System.out.print(">> ");
        String produtoEscolhido = scanner.nextLine();

        // Usar try catch para testar o tipo de entrada (int ou String)
        try {
            listaDeEstoques.get(Integer.parseInt(produtoEscolhido) - 1).getProduto().exibirInformacoes();
        } catch (NumberFormatException e){
            listaDeEstoques.stream().filter(estoque -> estoque.getProduto().getNome().equalsIgnoreCase(produtoEscolhido)).forEach(Estoque::exibirInformacoes);
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