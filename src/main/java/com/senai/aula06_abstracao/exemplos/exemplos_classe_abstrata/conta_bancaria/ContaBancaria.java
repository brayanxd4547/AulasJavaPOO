package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.conta_bancaria;

public abstract class ContaBancaria {
    protected String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("O saldo da conta bancária não pode ser negativo.");
        }
    }

    abstract void aplicarTaxaMensal();

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Foi depositado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O valor a ser depositado não pode ser negativo.");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor < saldo) {
            saldo -= valor;
            System.out.printf("Foi sacado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O valor a ser sacado não pode ser negativo e deve ser menor do que o saldo.");
            return false;
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        System.out.printf("Solicitação de transferência de R$%,.2f de %s para %s:\n", valor, this.titular, contaDestino.titular);
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
        }
    }

    public void exibirSaldo(){
        System.out.printf("Titular: %s\nSaldo: R$%,.2f\n", titular, saldo);
    }
}
