package com.senai.aula04_heranca.exercicios.ex04_sistema_de_atendimento_medico;

public class PacienteConvenio extends Paciente {
    private Double impostoImportacao;

    public PacienteConvenio(String nome, int idade, double custoConsulta, Double impostoImportacao) {
        super(nome, idade, custoConsulta);
        this.impostoImportacao = impostoImportacao;
    }

    public Double getDesconto() {
        return impostoImportacao;
    }

    public void setDesconto(Double impostoImportacao) {
        this.impostoImportacao = impostoImportacao;
    }

    @Override
    public Double calcularValorTotal() {
        return getCustoConsulta() - impostoImportacao;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.printf("""
                 | Desconto: %f
                 | Custo total: %f
                """, impostoImportacao, calcularValorTotal());
    }
}
