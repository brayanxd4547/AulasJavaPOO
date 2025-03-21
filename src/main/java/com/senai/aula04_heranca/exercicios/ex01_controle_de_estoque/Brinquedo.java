package com.senai.aula04_heranca.exercicios.ex01_controle_de_estoque;

public class Brinquedo extends Produto {
    private String cor;

    public Brinquedo(String nome, double preco, String marca, String cor) {
        super(nome, preco, marca);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Cor: %s
                """, cor);
    }
}
