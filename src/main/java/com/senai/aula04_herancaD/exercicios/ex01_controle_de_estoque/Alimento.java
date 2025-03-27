package com.senai.aula04_herancaD.exercicios.ex01_controle_de_estoque;

public class Alimento extends Produto {
    private String dataValidade;

    public Alimento(String nome, double preco, String marca, String dataValidade) {
        super(nome, preco, marca);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Data de validade: %s
                """, dataValidade);
    }
}
