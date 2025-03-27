package com.senai.aula05_polimorfismo.exemplosD.sobrecarga.produto;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("arroz");
        Produto produto2 = new Produto("feijão", 4);
        Produto produto3 = new Produto("macarrão", 10, 990);
        Produto produto4 = new Produto(); //

        System.out.println(produto1);
        System.out.println(produto2);
        System.out.println(produto3);
        System.out.println(produto4);
    }
}
