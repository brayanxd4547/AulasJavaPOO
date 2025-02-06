package com.senai.aula01_introducao_poo.exemplos.concessionaria;

import java.lang.Math;

public class Carro {
    // Atributos
    String modelo;
    String cor;
    float velMax;
    boolean eletrico;
    String marca;
    float quilometragem;
    int ano;
    double valor;

    // Construtor: cria o objeto e obriga a inserção de atributos no Main
    public Carro(String modelo, String cor, float velMax, boolean eletrico, String marca, float quilometragem, int ano, double precoOriginal) {
        this.modelo = modelo;
        this.cor = cor;
        this.velMax = velMax;
        this.eletrico = eletrico;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.ano = ano;
        this.valor = precoOriginal;
    }

    // Métodos
    public void testDrive(float minutos) {
        System.out.println("Durante o test drive, o " + modelo + " " + cor + " percorreu " + velMax * (minutos/60) + "km em " + minutos + " minutos.");
        quilometragem += velMax * (minutos/60);
    }

    public void comprar(String nomeCliente) {
        System.out.println(nomeCliente + " comprou o " + modelo + " " + cor + " por R$" + valor);
    }

    public void valorTabelaFlip(int anoReferencia){
        float valorDesvalorizado = (float) valor;
        for (int i = 0; i < anoReferencia - ano; i++) {
            valorDesvalorizado *= 0.98f;
        }
        System.out.printf("O %s vale R$%,.2f em %d de acordo com a tabela flipe.",
                modelo + " " + cor, valorDesvalorizado, anoReferencia);
    }

    // toString: converte os dados para texto
    @Override
    public String toString() {
        return  "Modelo: " + modelo + '\n' +
                "Cor: " + cor + '\n' +
                "Velocidade Máxima (km/h): " + velMax + '\n' +
                "Elétrico? " + eletrico + '\n' +
                "Marca: " + marca + '\n' +
                "Quilometragem: " + quilometragem + '\n' +
                "Ano: " + ano + '\n' +
                "Valor (reais): " + valor + '\n';
    }
}