package com.senai.aula05_polimorfismo.exercicios.ex05_sistema_de_beneficios_de_funcionarios;

public class ValeTransporte extends Beneficio {
    public ValeTransporte(double valor) {
        super(valor);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                 | Desconto do VT: R$%,.2f
                """, desconto);
    }
}
