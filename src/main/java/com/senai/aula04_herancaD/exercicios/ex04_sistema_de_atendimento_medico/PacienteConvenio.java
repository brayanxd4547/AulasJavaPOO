package com.senai.aula04_herancaD.exercicios.ex04_sistema_de_atendimento_medico;

public class PacienteConvenio extends Paciente {
    private Double desconto;

    public PacienteConvenio(String nome, int idade, double custoConsulta, Double desconto) {
        super(nome, idade, custoConsulta);
        this.desconto = desconto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    @Override
    public Double calcularValorTotal() {
        return getCustoConsulta() - desconto;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Desconto: %f
                 | Custo total: %f
                """, desconto, calcularValorTotal());
    }
}
