package com.senai.aula05_polimorfismo.exercicios.ex05_sistema_de_beneficios_de_funcionarios;

public class PlanoDeSaude extends Beneficio {
    public PlanoDeSaude(double valor) {
        super(valor);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf("""
                 | Desconto do plano de saúde: R$%,.2f
                """, desconto);
    }
}
