package com.senai.aula01_introducao_poo.exemplos.pessoa;

public class Endereco {
    // Atributos
    String rua;
    int numero;
    String bairro;
    String cidade;
    String estado;

    // Construtor: cria o objeto e obriga a inserção de atributos no Main
    public Endereco(String estado, String cidade, String bairro, int numero, String rua) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.rua = rua;
    }

    // toString: converte os dados para texto
    @Override // Indica que o método em questão é deste objeto, e não do raíz (chamado Object)
    public String toString() {
        return "\tRua: " + this.rua + "\n" +
                "\tNúmero: " + this.numero + "\n" +
                "\tBairro: " + this.bairro + "\n" +
                "\tCidade: " + this.cidade + "\n" +
                "\tEstado: " + this.estado;
    }
}