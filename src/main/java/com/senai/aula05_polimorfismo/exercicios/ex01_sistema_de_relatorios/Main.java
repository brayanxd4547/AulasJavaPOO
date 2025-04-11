package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class Main {
    public static void main(String[] args) {
        testarRelatorio(new PDF());
        testarRelatorio(new CSV());
        testarRelatorio(new JSON());
    }

    public static void testarRelatorio(Relatorio relatorio){
        relatorio.gerar();
    }
}
