package com.senai.aula04_heranca.exercicios.ex05_sistema_de_bibliotecas;

public class LivroFisico extends Livro{
    private int numPags;

    public LivroFisico(String titulo, String autor, int numPags) {
        super(titulo, autor);
        this.numPags = numPags;
        this.digital = false;
    }

    public int getNumPags() {
        return numPags;
    }

    public void setNumPags(int numPags) {
        this.numPags = numPags;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Número de páginas: %d
                """, numPags);
    }
}
