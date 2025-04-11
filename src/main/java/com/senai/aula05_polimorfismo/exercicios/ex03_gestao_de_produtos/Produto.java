package com.senai.aula05_polimorfismo.exercicios.ex03_gestao_de_produtos;

public class Produto {
    private String nome;
    private double custoOriginal;

    public Produto(String nome, double custoTotal) {
        this.nome = nome;
        this.custoOriginal = custoTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoOriginal() {
        return custoOriginal;
    }

    public void setCustoOriginal(double custoOriginal) {
        this.custoOriginal = custoOriginal;
    }

    public void exibirInformacoes() {
        System.out.printf("""
                 | Produto: %s
                 | Custo original: R$%,.2f
                """, nome, custoOriginal);
    }
}
