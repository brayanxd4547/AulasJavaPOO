package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class PDF extends Relatorio{
    @Override
    public void gerar() {
        System.out.println("Arquivo PDF gerado com sucesso!");
    }
}
