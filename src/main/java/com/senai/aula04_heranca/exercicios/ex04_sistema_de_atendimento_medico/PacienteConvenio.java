package com.senai.aula04_heranca.exercicios.ex04_sistema_de_atendimento_medico;

public class PacienteConvenio extends Paciente {
    private double desconto;

    public PacienteConvenio(String nome, int idade, double custoConsulta, double desconto) {
        super(nome, idade, custoConsulta);
        this.desconto = desconto;
        this.convenio = true;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
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
                 | Desconto: R$%,.2f
                 | Custo total: R$%,.2f
                """, desconto, calcularValorTotal());
    }
}
