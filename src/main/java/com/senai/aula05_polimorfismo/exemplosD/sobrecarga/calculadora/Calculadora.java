package com.senai.aula05_polimorfismo.exemplosD.sobrecarga.calculadora;

public class Calculadora {

    // Assinaturas da função: o nome ou os parâmetros
    // Com assinaturas diferentes, dois métodos podem existir com os mesmos nomes ou mesmos parâmetros

    int somar (int a, int b) {
        System.out.println("int, int");
        return a + b;
    }

    int somar (int a, int b, int c) {
        System.out.println("int, int, int");
        return a + b + c;
    }

    // Modificador de acesso ou modificador de propriedade não são parâmetros
    double somar (double a, double b) {
        System.out.println("double, double");
        return a + b;
    }

    double somar (double a, int b) {
        System.out.println("double, int");
        return a + b;
    }

    double somar (int a, double b) {
        System.out.println("int, double");
        return a + b;
    }
}
