package com.senai.aula04_herancaD.exemplos.veiculo;

public class Carro extends Veiculo {
    private int qtdPortas;

    public Carro(String marca, int ano, int qtdPortas) {
        super(marca, ano);
        this.qtdPortas = qtdPortas;
    }

    // Getter e setter de qtdPortas

    public int getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.print(
                "Quantidade de portas: " + qtdPortas + '\n'
        );
    }
}
