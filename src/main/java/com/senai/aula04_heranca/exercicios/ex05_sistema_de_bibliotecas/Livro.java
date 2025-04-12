package com.senai.aula04_heranca.exercicios.ex05_sistema_de_bibliotecas;

public class Livro {
    private String titulo;
    private String autor;
    protected boolean digital;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Título da obra: %s
                 | Autor: %s
                """, titulo, autor);
    }
}
