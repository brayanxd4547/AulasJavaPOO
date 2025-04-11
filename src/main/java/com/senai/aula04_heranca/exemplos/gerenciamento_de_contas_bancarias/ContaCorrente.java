package com.senai.aula04_heranca.exemplos.gerenciamento_de_contas_bancarias;

public class ContaCorrente extends ContaBancaria {
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite)  {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo + limite) {
            saldo -= valor;
            System.out.printf("Foi sacado R$%,.2f à conta de " + this.getTitular() + ". O novo saldo é R$%,.2f\n", valor, saldo);
            return true;
        } else {
            System.out.println("O valor a ser sacado não pode ser negativo e deve ser menor do que o saldo.");
            return false;
        }
    }
}
