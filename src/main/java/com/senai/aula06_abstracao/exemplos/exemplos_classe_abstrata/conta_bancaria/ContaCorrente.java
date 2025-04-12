package com.senai.aula06_abstracao.exemplos.exemplos_classe_abstrata.conta_bancaria;

public class ContaCorrente extends ContaBancaria {
    private double limite;

    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    void aplicarTaxaMensal() {
        saldo += 0.05 * saldo;
    }

    /*@Override
    public boolean sacar(double desconto) {
        if (desconto > 0 && desconto <= saldo + limite) {
            saldo -= desconto;
            System.out.printf("Foi sacado R$%,.2f à conta de " + this.getTitular() + ". O novo saldo é R$%,.2f\n", desconto, saldo);
            return true;
        } else {
            System.out.println("O desconto a ser sacado não pode ser negativo e deve ser menor do que o saldo.");
            return false;
        }
    }*/
}
