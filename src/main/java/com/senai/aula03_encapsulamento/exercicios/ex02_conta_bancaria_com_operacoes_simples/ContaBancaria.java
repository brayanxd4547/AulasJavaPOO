package com.senai.aula03_encapsulamento.exercicios.ex02_conta_bancaria_com_operacoes_simples;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        if (saldo >= 0){
            this.saldo = saldo;
        } else {
            throw new IllegalArgumentException("O saldo da conta bancária não pode ser negativo.");
        }
    }

    // Getters e setters

    // Nome
    public String getTitular(){
        return titular;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    // Preço
    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        if (saldo >= 0){
            this.saldo = saldo;
        } else {
            throw new IllegalArgumentException("O saldo da conta bancária não pode ser negativo.");
        }
    }

    // Funções

    public void depositar(double valor){
        if(valor > 0) {
            saldo += valor;
            System.out.printf("Foi depositado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
        } else {
            throw new IllegalArgumentException("O valor a ser depositado não pode ser negativo.");
        }
    }

    public void sacar(double valor){
        if(valor > 0 && valor < saldo) {
            saldo -= valor;
            System.out.printf("Foi sacado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
        } else {
            throw new IllegalArgumentException("O valor a ser sacado não pode ser negativo e deve ser menor do que o saldo.");
        }
    }

    @Override
    public String toString() {
        return  "Titular da conta bancária: " + titular + "\n" +
                "Saldo: " + saldo + "\n";
    }
}
