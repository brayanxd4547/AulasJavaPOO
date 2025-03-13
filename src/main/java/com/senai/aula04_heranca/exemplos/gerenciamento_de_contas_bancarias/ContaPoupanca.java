package com.senai.aula04_heranca.exemplos.gerenciamento_de_contas_bancarias;

public class ContaPoupanca extends ContaBancaria {
    private double taxaDeRendimento;

    public ContaPoupanca(String titular, double saldo, double taxaDeRendimento) {
        super(titular, saldo);
        this.taxaDeRendimento = taxaDeRendimento;
    }

    //todo: GETTER E SETTER

    public void aplicarRendimento(){
        saldo += taxaDeRendimento/100 * saldo;
    }
}
