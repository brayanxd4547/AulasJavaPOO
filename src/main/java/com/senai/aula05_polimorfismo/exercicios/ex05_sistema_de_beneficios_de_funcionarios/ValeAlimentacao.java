package com.senai.aula05_polimorfismo.exercicios.ex05_sistema_de_beneficios_de_funcionarios;

public class ValeAlimentacao extends Beneficio {
    public ValeAlimentacao(double valor) {
        super(valor);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                 | Desconto do VA: R$%,.2f
                """, desconto);
    }
}
