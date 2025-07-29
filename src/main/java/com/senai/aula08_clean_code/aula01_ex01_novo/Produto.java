package com.senai.aula08_clean_code.aula01_ex01_novo;

public class Produto {
    String nome;
    float preco;
    int quantidade;

    public Produto(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void exibirDetalhes() {
        System.out.println("Nome do produto: " + nome + '\n' +
                           "Preço: " + preco + '\n' +
                           "Quantidade em estoque: " + quantidade + '\n');
    }

    public void atualizaEstoque(boolean incrementar, int mudaQtd) {
        System.out.println("Ao estoque de " + nome + " foi " + (incrementar ? "incrementado " : "reduzido " + mudaQtd + " itens."));
        mudaQtd = incrementar ? mudaQtd : mudaQtd * -1;
        quantidade += mudaQtd;
        System.out.println();
    }

    public float calcularValorEstoque() {
        return quantidade * preco;
    }
}
