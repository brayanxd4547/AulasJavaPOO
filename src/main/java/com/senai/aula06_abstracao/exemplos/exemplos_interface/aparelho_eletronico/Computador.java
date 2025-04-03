package com.senai.aula06_abstracao.exemplos.exemplos_interface.aparelho_eletronico;

public class Computador implements AparelhoEletronico{
    @Override
    public void ligar() {
        System.out.println("O computador ligou.");
    }

    @Override
    public void desligar() {
        System.out.println("O computador desligou.");
    }
}
