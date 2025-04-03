package com.senai.aula06_abstracao.exemplos.exemplos_interface.aparelho_eletronico;

public class Main {
    public static void main(String[] args) {
        testarAparelhoEletronico(new Computador());
        testarAparelhoEletronico(new Televisao());
    }

    public static void testarAparelhoEletronico(AparelhoEletronico aparelhoEletronico){
        aparelhoEletronico.ligar();
        aparelhoEletronico.desligar();
    }
}
