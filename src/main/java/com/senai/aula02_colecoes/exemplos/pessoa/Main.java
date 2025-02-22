package com.senai.aula02_colecoes.exemplos.pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pessoa pessoa1 = new Pessoa("Umberto", 10);
        Pessoa pessoa2 = new Pessoa("Doisberto", 20);
        Pessoa pessoa3 = new Pessoa("Tresberto", 30);

        Pessoa[] matrizPessoas = new Pessoa[4];

        matrizPessoas[0] = pessoa1;
        matrizPessoas[1] = pessoa2;
        matrizPessoas[2] = pessoa3;

        for (Pessoa pessoa : matrizPessoas) {
            System.out.println(pessoa);
        }

        matrizPessoas[0].falar("Convocarei o quarto integrante da família.");

        matrizPessoas[3] = new Pessoa("Quatroberto", 40);
        System.out.println(matrizPessoas[3].nome);

        // Criando um ArrayList (lista)
        ArrayList lista = new ArrayList();

        // add: adiciona elementos (com ou sem índice) na lista (tamanho variável)
        lista.add(3);
        lista.add(true);
        lista.add("ygiy");
        lista.add(pessoa1);

        // get: retorna o elemento da lista com o índice escolhido
        Pessoa pessoa = (Pessoa) lista.get(3);
        pessoa.falar("Todos os membros estão convocados.\n");

        // <diamond>: limita os tipos de elemento por tipo de objeto
        ArrayList<Pessoa> listaPessoas = new ArrayList();

        listaPessoas.add(matrizPessoas[0]);
        listaPessoas.add(matrizPessoas[1]);
        listaPessoas.add(matrizPessoas[2]);
        listaPessoas.add(matrizPessoas[3]);
        listaPessoas.add(new Pessoa("Cincoberto", 50));

        System.out.println("Tamanho da lista: " + listaPessoas.size());

        System.out.println("\n------------ Lista ------------"); // forEach: executa um comando para cada elemento na lista
        listaPessoas.forEach(System.out::println);

        System.out.println("\n------------ Lista ------------");
        listaPessoas.remove(pessoa1); // remove: remove um elemento da lista (pelo índice ou pela referência)
        listaPessoas.forEach(System.out::println);

        System.out.println("\n------------ Lista ------------");
        listaPessoas.set(0, pessoa1); // set: substitui um elemento da lista por outro
        listaPessoas.forEach(System.out::println);

        System.out.println("\n------------ Lista ------------");
        listaPessoas.add(0, pessoa2);
        listaPessoas.forEach(System.out::println);

        System.out.println("\nFiltrando para apenas as pessoas com idade igual a 30 ou maior:");
        // stream: executa certas funções num fluxo de cada elemento da lista
        // filter: filtra apenas os elementos que retornam "true" a uma condição
        // toList: reagrupa os elementos em uma lista
        listaPessoas.stream().filter(p -> p.idade >= 30).toList().forEach(System.out::println);

        System.out.println("\nFiltrando para apenas as pessoas com 'ober' no nome:");
        listaPessoas.stream().filter(p -> p.nome.toLowerCase().contains("ober")).toList().forEach(System.out::println);

        System.out.println("Preencha as informações a seguir: ");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        listaPessoas.add(new Pessoa(nome, idade));
        System.out.println("\n------------ Lista ------------");
        listaPessoas.forEach(System.out::println);

        scanner.close();
    }
}
