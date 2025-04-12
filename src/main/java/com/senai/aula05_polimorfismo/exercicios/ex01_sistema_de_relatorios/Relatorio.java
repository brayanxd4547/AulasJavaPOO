package com.senai.aula05_polimorfismo.exercicios.ex01_sistema_de_relatorios;

public class Relatorio {
    private String titulo;
    private int numPags;
    protected String tipo;

    public Relatorio(String titulo, int numPags) {
        this.titulo = titulo;
        this.numPags = numPags;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumPags() {
        return numPags;
    }

    public void setNumPags(int numPags) {
        this.numPags = numPags;
    }

    public void gerar() {
        System.out.println("Relatório gerado!");
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Título do relatório: %s
                 | Quantidade de páginas: %s
                """, titulo, numPags);
    }
}
