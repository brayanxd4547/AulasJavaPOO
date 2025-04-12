package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class RelatorioCSV extends Relatorio{
    public RelatorioCSV(String titulo, int numPags) {
        super(titulo, numPags);
        this.tipo = "csv";
    }

    @Override
    public void gerar() {
        System.out.println("Arquivo CSV gerado com sucesso!");
    }
}
