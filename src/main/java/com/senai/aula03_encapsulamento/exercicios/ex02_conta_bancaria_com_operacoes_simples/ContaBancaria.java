package com.senai.aula03_encapsulamento.exercicios.ex02_conta_bancaria_com_operacoes_simples;

import java.util.Objects;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        if (saldo >= 0){
            this.saldo = saldo;
        } else {
            System.out.println("O saldo da conta bancária não pode ser negativo.");
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

    // Funções

    public boolean depositar(double valor){
        if(valor > 0) {
            saldo += valor;
            System.out.printf("Foi depositado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O valor a ser depositado não pode ser negativo.");
            return false;
        }
    }

    public boolean sacar(double valor){
        if(valor > 0 && valor < saldo) {
            saldo -= valor;
            System.out.printf("Foi sacado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O valor a ser sacado não pode ser negativo e deve ser menor do que o saldo.");
            return false;
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino){
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return Double.compare(saldo, that.saldo) == 0 && Objects.equals(titular, that.titular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titular, saldo);
    }

    @Override
    public String toString() {
        return  "Titular da conta bancária: " + titular + "\n" +
                "Saldo: " + saldo + "\n";
    }
}
