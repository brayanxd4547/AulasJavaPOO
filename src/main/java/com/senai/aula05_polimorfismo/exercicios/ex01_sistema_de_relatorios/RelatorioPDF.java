package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class RelatorioPDF extends Relatorio{
    public RelatorioPDF(String titulo, int numPags) {
        super(titulo, numPags);
        this.tipo = "pdf";
    }

    @Override
    public void gerar() {
        System.out.println("Arquivo PDF gerado com sucesso!");
    }
}
