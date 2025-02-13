package com.senai.aula02_colecoes.exemplos.pessoa;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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

        matrizPessoas[0].falar("Alô galera de cowboy");

        matrizPessoas[3] = new Pessoa("Quatroberto", 40);
        System.out.println(matrizPessoas[3].nome);

        ArrayList lista = new ArrayList();

        lista.add(3);
        lista.add(true);
        lista.add("ygiy");
        lista.add(pessoa1);

        Pessoa pessoa = (Pessoa) lista.get(3);
        pessoa.falar("Alô");

        ArrayList<Pessoa> listaPessoas = new ArrayList();

        listaPessoas.add(pessoa1);
        listaPessoas.add(new Pessoa("Cincoberto", 50));

        System.out.println("size: " + listaPessoas.size());

        listar(listaPessoas);

        listaPessoas.remove(pessoa1);
        listar(listaPessoas);

        listaPessoas.set(0, pessoa2);
        listar(listaPessoas);

        listaPessoas.add(0, pessoa3);
        listar(listaPessoas);
    }

    public static void listar(ArrayList<Pessoa> lista) {
        for (Pessoa pessoa : lista){
            System.out.println(pessoa);
        }
        System.out.println();
    }
}
