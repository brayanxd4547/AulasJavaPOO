package com.senai.aula06_abstracao.exercicios.ex01_sistema_padronizado_de_check_in;

public class Main {
    public static void main(String[] args) {
        CheckIn azul = new AzulLinhasAereas();
        CheckIn gol = new GolLinhasAereas();
        CheckIn latam = new LATAMAirlinesBrasil();

        testeCheckIn(azul, "João Pereira Neres", true, 200);
        testeCheckIn(gol, "Maria Christina dos Reis", true, 150);
        testeCheckIn(latam, "Samuel Oliveria Marins", false, 100);
    }

    public static void testeCheckIn(CheckIn companhia, String cliente, boolean vooInternacional, float pesoBagagem){
        System.out.println();
        companhia.exibirBoasVindasCompanhia();
        companhia.realizarCheckIn(cliente, vooInternacional, pesoBagagem);
    }
}
