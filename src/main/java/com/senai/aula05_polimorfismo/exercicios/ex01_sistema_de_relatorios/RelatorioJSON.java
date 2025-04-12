package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class RelatorioJSON extends Relatorio {
    public RelatorioJSON(String titulo, int numPags) {
        super(titulo, numPags);
        this.tipo = "json";
    }

    @Override
    public void gerar() {
        System.out.println("Arquivo JSON gerado com sucesso!");
    }
}
