package com.senai.aula04_heranca.exercicios.ex01_controle_de_estoque;

public class Eletronico extends Produto{
    private float tensaoEletrica;
    private float correnteEletrica;

    public Eletronico(String nome, double preco, String marca, float tensaoEletrica, float correnteEletrica) {
        super(nome, preco, marca);
        this.tensaoEletrica = tensaoEletrica;
        this.correnteEletrica = correnteEletrica;
    }

    public float getTensaoEletrica() {
        return tensaoEletrica;
    }

    public void setTensaoEletrica(float tensaoEletrica) {
        this.tensaoEletrica = tensaoEletrica;
    }

    public float getCorrenteEletrica() {
        return correnteEletrica;
    }

    public void setCorrenteEletrica(float correnteEletrica) {
        this.correnteEletrica = correnteEletrica;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.print(
                "Tensão elétrica: " + this.tensaoEletrica + "\n" +
                "Corrente elétrica: " + this.tensaoEletrica + "\n"
        );
    }
}
