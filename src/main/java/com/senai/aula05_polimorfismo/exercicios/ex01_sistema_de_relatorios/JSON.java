package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class JSON extends Relatorio {
    @Override
    public void gerar() {
        System.out.println("Arquivo JSON gerado com sucesso!");
    }
}
