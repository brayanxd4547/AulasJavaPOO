package com.senai.aula04_heranca.exercicios.ex04_sistema_de_atendimento_medico;

public class PacienteParticular extends Paciente{
    public PacienteParticular(String nome, int idade, double custoConsulta) {
        super(nome, idade, custoConsulta);
        this.convenio = false;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Custo total: %f
                """, calcularValorTotal());
    }
}
