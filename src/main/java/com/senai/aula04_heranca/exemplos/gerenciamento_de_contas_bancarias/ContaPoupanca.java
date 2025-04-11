package com.senai.aula04_heranca.exemplos.gerenciamento_de_contas_bancarias;

public class ContaPoupanca extends ContaBancaria {
    private double taxaDeRendimento;

    public ContaPoupanca(String titular, double saldo, double taxaDeRendimento) {
        super(titular, saldo);
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public double getTaxaDeRendimento() {
        return taxaDeRendimento;
    }

    public void setTaxaDeRendimento(double taxaDeRendimento) {
        this.taxaDeRendimento = taxaDeRendimento;
        System.out.println("A taxa de rendimento foi redefinida para " + taxaDeRendimento + "%.");
    }

    public void aplicarRendimento(){
        saldo += taxaDeRendimento/100 * saldo;
        System.out.println("Foi aplicado um rendimento de " + this.taxaDeRendimento + "%. O novo saldo da conta é " + this.saldo);
    }
}
