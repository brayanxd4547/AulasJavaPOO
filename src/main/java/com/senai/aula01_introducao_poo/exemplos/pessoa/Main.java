package com.senai.aula01_introducao_poo.exemplos.pessoa;

public class Main {
    public static void main(String[] args) {
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
                        "Itamanhaém"
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
        pessoa2.falar("Eu não consigo descrever o sentimento que acabei de sentir.");

        Pessoa pessoa3 = new Pessoa("João Ninguém", 0);
        System.out.println(pessoa3);
    }
}
