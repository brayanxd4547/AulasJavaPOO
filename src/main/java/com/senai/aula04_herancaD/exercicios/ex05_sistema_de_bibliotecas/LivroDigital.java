package com.senai.aula04_herancaD.exercicios.ex05_sistema_de_bibliotecas;

public class LivroDigital extends Livro{
    private float tamanho;

    public LivroDigital(String titulo, String autor, float tamanho) {
        super(titulo, autor);
        this.tamanho = tamanho;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Tamanho (em MB): %f
                """, tamanho);
    }
}
