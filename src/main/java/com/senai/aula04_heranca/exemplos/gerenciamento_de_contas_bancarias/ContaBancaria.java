package com.senai.aula04_heranca.exemplos.gerenciamento_de_contas_bancarias;

public class ContaBancaria {
    private String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("O saldo da conta bancária não pode ser negativo.");
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Foi depositado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O desconto a ser depositado não pode ser negativo.");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor < saldo) {
            saldo -= valor;
            System.out.printf("Foi sacado R$%,.2f à conta de " + this.titular + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O desconto a ser sacado não pode ser negativo e deve ser menor do que o saldo.");
            return false;
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        System.out.printf("Solicitação de transferência de R$%,.2f de %s para %s:\n", valor, this.titular, contaDestino.getTitular());
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
        }
    }

    public void exibirSaldo(){
        System.out.printf("Titular: %s\nSaldo: R$%,.2f\n", titular, saldo);
    }
}
