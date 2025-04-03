package com.senai.aula06_abstracao.exemplos.exemplos_interface.aparelho_eletronico;

public class Televisao implements AparelhoEletronico{
    @Override
    public void desligar() {
        System.out.println("A televisão ligou.");
    }

    @Override
    public void ligar() {
        System.out.println("A televisão desligou.");
    }
}
