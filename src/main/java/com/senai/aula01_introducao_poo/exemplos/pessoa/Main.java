package com.senai.aula01_introducao_poo.exemplos.pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Construindo objeto "pessoa1" da classe "Pessoa"
        Pessoa pessoa1 = new Pessoa(
                "Rafael",
                40,
                1.8f,

                // Criando um objeto dentro do parâmetro de "pessoa1"
                new Endereco(
                        "SP",
                        "São Bernardo do Campo",
                        "Baeta Neves",
                        66,
                        "Rua Catanduva"
                )
        );

        // Construindo objeto "pessoa2" da classe "Pessoa"
        Pessoa pessoa2 = new Pessoa(
                "Gilberto",
                97,
                1.8f,

                // Criando um objeto dentro do parâmetro de "pessoa1"
                new Endereco(
                        "SP",
                        "Itaquaquecetuba",
                        "Itapenitinga",
                        130,
                        "Itanhaaém"
                )
        );

        // Exibe os dados do objeto "pessoa1"
        System.out.println(pessoa1);
        System.out.println(pessoa2);

        // Diálogo de alto nível
        pessoa1.falar("Pneumoultramicroscopicossilicovulcanoconiótico.");
        pessoa2.falar("Essa palavra é muito grande.");
        pessoa1.falar("Sim, me deu até fome.");
        pessoa1.comer("groselha que parece limão com sabor de tamarindo");
        pessoa2.falar("Que raios você está comendo?");
        pessoa1.falar("Experimenta.");
        pessoa2.comer("groselha que parece limão com sabor de tamarindo");
        pessoa2.falar("Exótico.");
        System.out.println();

        System.out.println(" - CRIAÇÃO DE NOVA PESSOA - ");

        String[] etiquetas = {"Nome: ", "Idade: ", "Altura: ", "Endereço:\n\tEstado: ", "\tCidade: ", "\tBairro: ", "\tNúmero da rua: ", "\tRua: "};
        String[] dados = new String[etiquetas.length];
        System.out.println("Insira os dados da pessoa criada.");
        for (int i = 0; i < etiquetas.length; i++) {
            System.out.print(etiquetas[i]);
            dados[i] = scanner.nextLine();
        }

        Pessoa pessoa3 = new Pessoa (
                dados[0],
                Integer.parseInt(dados[1]),
                Float.parseFloat(dados[2]),
            new Endereco(
                    dados[3],
                    dados[4],
                    dados[5],
                    Integer.parseInt(dados[6]),
                    dados[7]
            )
        );
        System.out.println();

        System.out.println(pessoa3);

        scanner.close();
    }
}
